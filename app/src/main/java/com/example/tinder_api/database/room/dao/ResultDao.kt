package com.example.tinder_api.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tinder_api.database.network.responses.ResultsResponse
import com.example.tinder_api.database.room.model.Item
import com.example.tinder_api.database.room.model.Name
import com.example.tinder_api.database.room.model.Result
import kotlinx.coroutines.Deferred

@Dao
interface ResultDao {

    @Query("SELECT * from items")
    fun get(): LiveData<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg item: Item)

    @Query("UPDATE items SET results = :res")
    suspend fun update(res: List<Result>)
}