package com.example.influxapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.influxapp.database.models.Goals


@Dao
interface GoalsDao {

    @Query("SELECT * from goal")
    fun getAllGoal(): LiveData<List<Goals>>

    @Insert
    suspend fun insertAllGoal(vararg transaction: Goals)

    @Delete
    suspend fun deleteGoal(transaction: Goals)

    @Update
    suspend fun update(vararg transaction: Goals)
}