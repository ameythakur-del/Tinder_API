package com.example.tinder_api.ui.main

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.example.tinder_api.database.repository.Repository
import com.example.tinder_api.database.room.ItemsDatabase
import com.example.tinder_api.database.room.model.Item
import com.example.tinder_api.database.room.model.Name
import com.example.tinder_api.database.room.model.Result
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.lang.reflect.Array.get
import java.util.*


class MainViewModel(application: Application) : AndroidViewModel(application) {

    // The internal MutableLiveData String that stores the most recent response
    private val database = ItemsDatabase.getDatabase(application)
    private val itemsRepository = Repository(database)

    var status = MutableLiveData<String?>()

    /**
     * init{} is called immediately when this ViewModel is created.
     */
    val handler = CoroutineExceptionHandler { _, exception ->

    }
    init {
        viewModelScope.launch(handler) {
            itemsRepository.refreshItems()
        }
    }

    var playlist: LiveData<Item> = itemsRepository.items

    fun onAcceptClicked(result: Result){
        viewModelScope.launch() {
            itemsRepository.setStatusAccepted(result.cell)
        }
    }

    fun onDeclineClicked(result: Result){
        viewModelScope.launch() {
            itemsRepository.setStatusDeclined(result.cell)
        }
    }
}