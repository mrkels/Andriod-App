package com.example.influxapp.database;

import java.lang.System;

@androidx.room.Database(entities = {com.example.influxapp.database.models.UserModel.class, com.example.influxapp.database.models.Expense.class, com.example.influxapp.database.models.Goals.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/influxapp/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "expenseDao", "Lcom/example/influxapp/database/ExpenseDao;", "goalDao", "Lcom/example/influxapp/database/GoalsDao;", "userModelDao", "Lcom/example/influxapp/database/UserModelDao;", "app_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.influxapp.database.UserModelDao userModelDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.influxapp.database.ExpenseDao expenseDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.influxapp.database.GoalsDao goalDao();
}