package com.example.tinder_api.database.room.model

import androidx.room.Entity

@Entity
data class Name(
    val first: String,
    val last: String,
    val title: String
)