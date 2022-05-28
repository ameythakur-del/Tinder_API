package com.example.tinder_api

import com.example.tinder_api.model.Item
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers


interface ItemsApi {
    @GET("/")
    suspend fun getItems() : Response<List<Item>>

    companion object {
        operator fun invoke(): ItemsApi {

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://randomuser.me/api/?results=10")
                .build()
                .create(ItemsApi::class.java)
        }
    }
}