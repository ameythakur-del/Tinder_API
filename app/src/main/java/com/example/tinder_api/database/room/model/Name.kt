package com.example.tinder_api.database.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Name(
    @PrimaryKey(autoGenerate = false)
    val first: String,
    val last: String,
    val title: String
)