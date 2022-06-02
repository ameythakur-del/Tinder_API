package com.example.tinder_api.database.room.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Results")
data class Result(
    val cell: String,

    @Embedded
    var dob: Dob,

    val email: String,
    val gender: String,

    @Embedded
    val id: Id,

    @Embedded
    val location: Location,

    @Embedded
    val login: Login,

    @PrimaryKey(autoGenerate = false)
    @Embedded
    val name: Name,
    val nat: String,
    val phone: String,

    @Embedded
    val picture: Picture,

    @Embedded(prefix = "reg_")
    val registered: Registered,

    var status: String
)