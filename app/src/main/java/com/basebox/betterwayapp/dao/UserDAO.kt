package com.basebox.betterwayapp.dao

import androidx.room.*
import com.basebox.betterwayapp.entity.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(vararg users: User)

    @Update
    fun updateUsers(vararg users: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE email LIKE :email " +
            "AND password LIKE :password")
    suspend fun findUser(email: String, password: String): User

    @Delete
    fun deleteUsers(vararg users: User)
}