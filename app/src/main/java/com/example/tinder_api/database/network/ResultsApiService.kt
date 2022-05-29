package com.example.tinder_api.database.network



import com.example.tinder_api.database.network.responses.Results
import com.example.tinder_api.database.network.responses.ResultsResponse
import retrofit2.http.*

interface ResultsApiService {


    @GET("api/?results=10")
    suspend fun getResults(): ResultsResponse


}