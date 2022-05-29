package com.example.tinder_api.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tinder_api.database.model.Result

@Dao
interface ResultDao {
    @Query("SELECT * from results")
    fun get(): Result?
}