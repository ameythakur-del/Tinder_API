package com.example.tinder_api.database.repository

import com.example.tinder_api.database.network.ResultsApi



class Repository {

    suspend fun getResults() = ResultsApi.RETROFIT_SERVICE.getResults()
}