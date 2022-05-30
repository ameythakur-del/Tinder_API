package com.example.tinder_api.database.room.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.tinder_api.database.room.typeConverter.ResultConverter

@Entity(tableName = "Items")
data class Item constructor(
    @PrimaryKey(autoGenerate = false)
    @Embedded
    val info: Info,

//    @TypeConverters(ResultConverter::class)
    val results: Result
)


