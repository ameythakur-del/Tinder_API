package com.example.tinder_api.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.example.tinder_api.database.network.ResultsApi
import com.example.tinder_api.database.network.responses.ResultsResponse
import com.example.tinder_api.database.repository.Repository
import com.example.tinder_api.database.room.ItemsDatabase
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {

    // The internal MutableLiveData String that stores the most recent response
    private val database = ItemsDatabase.getDatabase(application)
    private val itemsRepository = Repository(database)

    /**
     * init{} is called immediately when this ViewModel is created.
     */
    init {
        viewModelScope.launch {
            itemsRepository.refreshItems()
        }
    }

    val playlist = itemsRepository.items

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}