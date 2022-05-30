package com.example.tinder_api.database.room.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Results")
data class Result(
    val cell: String,

    @Embedded
    val dob: Dob,

    val email: String,
    val gender: String,

    @PrimaryKey(autoGenerate = false)

    @Embedded
    val id: Id,

    @Embedded
    val location: Location,

    @Embedded
    val login: Login,

    @Embedded
    val name: Name,
    val nat: String,
    val phone: String,

    @Embedded
    val picture: Picture,

    @Embedded(prefix = "reg_")
    val registered: Registered
)