package com.example.tinder_api.database.repository

import android.net.Network
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.tinder_api.database.network.ResultsApi
import com.example.tinder_api.database.room.ItemsDatabase
import com.example.tinder_api.database.room.model.Info
import com.example.tinder_api.database.room.model.Item
import com.example.tinder_api.database.room.model.Name
import com.example.tinder_api.database.room.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//class Repository {
////    suspend fun getResults() = ResultsApi.retrofitService.getResults()
//}

class Repository(private val database: ItemsDatabase){

    val items = database.resultDao.get()

    suspend fun refreshItems() {
        withContext(Dispatchers.IO) {
            var item = ResultsApi.retrofitService.getResults()

            var info = Info(item.info.page, item.info.results, item.info.seed, item.info.version)

            database.resultDao.insertAll(item)
        }
    }
}