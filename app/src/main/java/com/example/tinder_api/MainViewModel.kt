package com.example.tinder_api


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tinder_api.database.network.responses.Results
import com.example.tinder_api.database.network.responses.ResultsResponse
import com.example.tinder_api.database.repository.Repository
import com.example.tinder_api.util.ApiStatus
import kotlinx.coroutines.launch


class MainViewModel(val repository: Repository, application: Application) :
    AndroidViewModel(application) {


    private val _snackBarText = MutableLiveData<String>()
    val snackBarText: LiveData<String> get() = _snackBarText

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    private val _ResultResponse: MutableLiveData<ResultsResponse> =
        MutableLiveData()
    val resultResponse: LiveData<ResultsResponse>
        get() = _ResultResponse

    /**
     * Variable that tells the fragment whether it should navigate to [ProductsFragment].
     *
     * This is `private` because we don't want to expose the ability to set [MutableLiveData] to
     * the [Fragment]
     */
    private val _navigateToProducts = MutableLiveData<Boolean?>()

    /**
     * When true immediately navigate back to the [Products]
     */
    val navigateToProducts: LiveData<Boolean?>
        get() = _navigateToProducts


    init {
        getAllResults()
    }
    fun getAllResults() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _ResultResponse.value = repository.getResults()
                Log.i("network error", _ResultResponse.value!!.toString())
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.i("network error", e.toString())
                _status.value = ApiStatus.ERROR
//                _ResultsResponse.value = ArrayList()
            }
        }
    }






}