package com.example.tinder_api.database.repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tinder_api.database.network.ResultsApi
import com.example.tinder_api.database.room.ItemsDatabase
import com.example.tinder_api.database.room.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import java.util.concurrent.Executor

class Repository(private val database: ItemsDatabase){

    var items : MutableLiveData<List<Result>> = MutableLiveData<List<Result>>(database.resultDao.get())
    var rs : MutableList<Result> = mutableListOf()

    suspend fun refreshItems() {
        withContext(Dispatchers.IO) {

            var item = ResultsApi.retrofitService.getResults().await()

            for (i in 0 until item.results.size){
                var thisDob = Dob(item.results[i].dob.age, item.results[i].dob.date)
                var thisId = Id(item.results[i].id.name, item.results[i].id.value)
                var thisCoordinate = Coordinates(item.results[i].location.coordinates.latitude, item.results[i].location.coordinates.longitude)
                var thisStreet = Street(item.results[i].location.street.name, item.results[i].location.street.number)
                var thisTime = Timezone(item.results[i].location.timezone.description, item.results[i].location.timezone.offset)
                var thisLocation = Location(item.results[i].location.city, thisCoordinate, item.results[i].location.country, item.results[i].location.postcode, item.results[i].location.state, thisStreet, thisTime)
                var thisLogin = Login(item.results[i].login.md5, item.results[i].login.password, item.results[i].login.salt, item.results[i].login.sha1, item.results[i].login.sha256, item.results[i].login.username, item.results[i].login.uuid)
                var thisName = Name(item.results[i].name.first, item.results[i].name.last, item.results[i].name.title)
                var thisPicture = Picture(item.results[i].picture.large, item.results[i].picture.medium, item.results[i].picture.thumbnail)
                var thisRegistered = Registered(item.results[i].registered.age, item.results[i].registered.date)

                var result =
                    Result(item.results[i].cell, thisDob, item.results[i].email, item.results[i].gender,
                        thisId, thisLocation, thisLogin, thisName, item.results[i].nat, item.results[i].phone, thisPicture, thisRegistered, "null")

                rs.add(result)
            }


            if(!items.value!!.isEmpty()) {
                database.resultDao.delete()
            }

            database.resultDao.insertAll(rs)
        }
        items.value = rs
    }


    suspend fun setStatusAccepted(email: String){
        withContext(Dispatchers.IO) {
            if (rs.isEmpty()) {
                rs = items.value!!.toMutableList()
            }
            database.resultDao.updateStatus("Accepted", email)
        }
        items.value = database.resultDao.get()
    }

    suspend fun setStatusDeclined(email: String){
        withContext(Dispatchers.IO) {
            if (rs.isEmpty()) {
                rs = items.value!!.toMutableList()
            }
            database.resultDao.updateStatus("Declined", email)
        }
        items.value = database.resultDao.get()
    }
}