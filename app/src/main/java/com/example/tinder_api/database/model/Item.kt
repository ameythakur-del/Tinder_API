package com.example.tinder_api.database.model

import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "Items")
data class Item(
    @Embedded
    val info: Info,

    @Embedded
    val results: List<Result>
)