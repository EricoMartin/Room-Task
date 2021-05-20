package com.basebox.betterwayapp.db

import android.content.Context
import com.basebox.betterwayapp.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserRepository(context: Context) {
    private val db = UserDB.invoke(context)

    fun getUser(email: String, password: String) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                db.userDao().findUser(email, password)
            }
        }
    }
        fun addUser(user: User) {
            GlobalScope.launch {
                withContext(Dispatchers.IO) {
                    db.userDao().insertUsers(user)
                }
            }
        }
}