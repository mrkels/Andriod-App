package com.example.influxapp.repository

import androidx.lifecycle.LiveData
import com.example.influxapp.database.AppDatabase
import com.example.influxapp.database.models.Expense
import com.example.influxapp.database.models.Goals
import com.example.influxapp.database.models.UserModel
import javax.inject.Inject

class Repository @Inject constructor(
    private val db: AppDatabase,

){

    fun allExpenses(): LiveData<List<Expense>> {
        return db.expenseDao().getAll()
    }

    suspend fun deleteExpense(expense: Expense) {
        db.expenseDao().delete(expense)
    }


    suspend fun insertAllExpense(expense: Expense) {
        db.expenseDao().insertAll(expense)
    }

    suspend fun updateExpense(expense: Expense) {
        db.expenseDao().update(expense)
    }


    fun allGoal(): LiveData<List<Goals>> {
        return db.goalDao().getAllGoal()
    }

    suspend fun deleteGoal(goal: Goals) {
        db.goalDao().deleteGoal(goal)
    }


    suspend fun insertAllGoal(goal: Goals) {
        db.goalDao().insertAllGoal(goal)
    }

    suspend fun updateGoal(goal: Goals) {
        db.goalDao().update(goal)
    }



    suspend fun signIn(userModel: UserModel) = db.userModelDao().createOrUpdateUsers(userModel)


    suspend fun saveOrUpdateUser(userModel: UserModel) {
        db.userModelDao().updateUser(userModel)
    }

    suspend fun saveUser(userModel: UserModel) {
        db.userModelDao().createOrUpdateUsers(userModel)
    }

    fun getUserByName(userName: String, pwd: String): LiveData<Boolean> {
        return db.userModelDao().getUserByName(userName, pwd)
    }

   fun myUsers(): LiveData<List<UserModel>> {
        return db.userModelDao().getAllUsers()
   }




}