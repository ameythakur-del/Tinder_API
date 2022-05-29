package com.example.tinder_api.database.model

import androidx.room.Entity

@Entity
data class Name(
    val first: String,
    val last: String,
    val title: String
)