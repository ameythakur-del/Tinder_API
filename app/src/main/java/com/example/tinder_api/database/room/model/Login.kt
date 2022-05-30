package com.example.tinder_api.database.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Login(
    @PrimaryKey(autoGenerate = false)
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String
)