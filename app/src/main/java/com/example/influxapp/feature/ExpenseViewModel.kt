package com.example.influxapp.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.influxapp.database.models.Expense
import com.example.influxapp.database.models.Goals
import com.example.influxapp.database.models.UserModel
import com.example.influxapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun fetchExpenses() = repository.allExpenses()


    fun insertExpense(expense: Expense) = viewModelScope.launch {
        repository.insertAllExpense(expense)
    }


    suspend fun deleteExpense(expense: Expense) {
        repository.deleteExpense(expense)
    }

    fun update(expense: Expense) = viewModelScope.launch {
        repository.updateExpense(expense)
    }


    //USER

    fun insertUser(userModel: UserModel) = viewModelScope.launch {
        repository.saveUser(userModel)
    }

    fun checkUser(userName: String, pwd: String) = repository.getUserByName(userName, pwd)


    //Goal

    fun fetchGoals() = repository.allGoal()


    fun insertGoal(goal: Goals) = viewModelScope.launch {
        repository.insertAllGoal(goal)
    }


    suspend fun deleteGoal(goal: Goals) {
        repository.deleteGoal(goal)
    }

    fun update(goal: Goals) = viewModelScope.launch {
        repository.updateGoal(goal)
    }
}