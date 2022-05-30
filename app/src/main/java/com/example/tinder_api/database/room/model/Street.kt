package com.example.tinder_api.database.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Street(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val number: Int
)