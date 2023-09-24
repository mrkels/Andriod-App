package com.example.influxapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.influxapp.database.models.Expense

@Dao
interface ExpenseDao {

    @Query("SELECT * from expenses")
    fun getAll(): LiveData<List<Expense>>

    @Insert
    suspend fun insertAll(vararg transaction: Expense)

    @Delete
    suspend fun delete(transaction: Expense)

    @Update
    suspend fun update(vararg transaction: Expense)
}