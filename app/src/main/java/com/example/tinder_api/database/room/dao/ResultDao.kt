package com.example.tinder_api.database.room.dao

import androidx.room.*
import com.example.tinder_api.database.room.model.Name
import com.example.tinder_api.database.room.model.Result

@Dao
interface ResultDao {

    @Query("SELECT * from results")
    fun get(): List<Result>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(results: List<Result>)

    @Update
    suspend fun update(results: List<Result>)

    @Query("UPDATE Results SET status = :st where email = :em")
    suspend fun updateStatus(st: String, em: String)

    @Query("DELETE from results")
    suspend fun delete()
}