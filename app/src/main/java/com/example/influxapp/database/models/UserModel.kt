package com.example.influxapp.database.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "user_table")
data class UserModel(
    @PrimaryKey(autoGenerate = true)  val id: Int,
    val name: String,
    val userName: String,
    val password: String,
    val isLogin: Boolean = false,
): Parcelable