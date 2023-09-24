package com.example.influxapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.influxapp.database.models.UserModel


@Dao
interface UserModelDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createOrUpdateUsers(userModel: UserModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(userModel: UserModel)

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): LiveData<List<UserModel>>


    @Query("Select * from user_table where isLogin= :loggedIn")
    fun userByFav(loggedIn: Boolean): LiveData<List<UserModel>>

    @Query("Select Exists(Select * from user_table where userName= :userId AND password = :pwd LIMIT 1)")
    fun getUserByName(userId: String, pwd: String): LiveData<Boolean>


}