package com.example.influxapp.database;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\'J\u0019\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0011\u001a\u00020\u000bH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/influxapp/database/UserModelDao;", "", "createOrUpdateUsers", "", "userModel", "Lcom/example/influxapp/database/models/UserModel;", "(Lcom/example/influxapp/database/models/UserModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllUsers", "Landroidx/lifecycle/LiveData;", "", "getUserByName", "", "userId", "", "pwd", "updateUser", "userByFav", "loggedIn", "app_debug"})
public abstract interface UserModelDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object createOrUpdateUsers(@org.jetbrains.annotations.NotNull
    com.example.influxapp.database.models.UserModel userModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    com.example.influxapp.database.models.UserModel userModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM user_table")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.influxapp.database.models.UserModel>> getAllUsers();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "Select * from user_table where isLogin= :loggedIn")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.influxapp.database.models.UserModel>> userByFav(boolean loggedIn);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "Select Exists(Select * from user_table where userName= :userId AND password = :pwd LIMIT 1)")
    public abstract androidx.lifecycle.LiveData<java.lang.Boolean> getUserByName(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String pwd);
}