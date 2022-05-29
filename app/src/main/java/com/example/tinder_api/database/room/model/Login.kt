package com.example.tinder_api.database.room.model

import androidx.room.Entity

@Entity
data class Login(
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String
)