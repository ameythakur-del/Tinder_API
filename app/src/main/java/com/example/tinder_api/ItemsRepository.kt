package com.example.tinder_api

class ItemsRepository (
    private val api: ItemsApi
) : SafeApiRequest(){
    suspend fun getItems() = apiRequest { api.getItems() }
}