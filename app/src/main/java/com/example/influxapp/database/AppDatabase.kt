package com.example.influxapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.influxapp.database.models.Expense
import com.example.influxapp.database.models.Goals
import com.example.influxapp.database.models.UserModel


@Database(entities = [UserModel::class, Expense::class, Goals::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userModelDao(): UserModelDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun goalDao(): GoalsDao
}