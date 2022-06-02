package com.example.tinder_api.database.network



import com.example.tinder_api.database.network.responses.Results
import com.example.tinder_api.database.network.responses.ResultsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.*

interface ResultsApiService {

    @GET("api/?results=10")
    fun getResults(): Deferred<ResultsResponse>
}