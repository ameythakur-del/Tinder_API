package com.example.tinder_api.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.example.tinder_api.database.repository.Repository
import com.example.tinder_api.database.room.ItemsDatabase
import com.example.tinder_api.database.room.model.Result
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
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

    var playlist: MutableLiveData<List<Result>> = itemsRepository.items

    fun onAcceptClicked(result: Result){
        viewModelScope.launch() {
            itemsRepository.setStatusAccepted(result.email)
        }
    }

    fun onDeclineClicked(result: Result){
        viewModelScope.launch() {
            itemsRepository.setStatusDeclined(result.email)
        }
    }
}