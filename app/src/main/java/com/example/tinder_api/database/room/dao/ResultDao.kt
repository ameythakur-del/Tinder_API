package com.example.tinder_api.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tinder_api.database.network.responses.ResultsResponse
import com.example.tinder_api.database.room.model.Item
import com.example.tinder_api.database.room.model.Result
import kotlinx.coroutines.Deferred

@Dao
interface ResultDao {

    @Query("SELECT * from results")
    fun get(): LiveData<Result>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg results: List<Result>)
}