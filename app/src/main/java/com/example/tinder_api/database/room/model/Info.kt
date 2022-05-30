package com.example.tinder_api.database.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Info(
    @PrimaryKey(autoGenerate = false)
    var page: Int,
    val results: Int,
    val seed: String,
    val version: String
)