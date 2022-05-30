package com.example.tinder_api.database.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dob(
    @PrimaryKey(autoGenerate = false)
    val age: Int,
    val date: String
)