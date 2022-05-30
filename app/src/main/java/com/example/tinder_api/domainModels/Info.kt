package com.example.tinder_api.domainModels

data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)