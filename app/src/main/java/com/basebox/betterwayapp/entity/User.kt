package com.basebox.betterwayapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Int ,
    val email: String?,
    val password: String?
)