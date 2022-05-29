package com.example.tinder_api.database.model

import androidx.room.Entity

@Entity
data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)