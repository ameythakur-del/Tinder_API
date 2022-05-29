package com.example.tinder_api.database.network.responses

data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)