package com.basebox.betterwayapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.basebox.betterwayapp.BaseActivity
import com.basebox.betterwayapp.databinding.ActivityLoginBinding
import com.basebox.betterwayapp.db.UserRepository
import com.basebox.betterwayapp.entity.User
import kotlinx.coroutines.runBlocking


class LoginActivity : AppCompatActivity() {
    private val TAG = "LoginActivity"

    private var emailUsed: String? = null
    private var passwordUsed: String? = null

    private var binding: ActivityLoginBinding? = null
    private lateinit var userRepo: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        userRepo = UserRepository(this)

        binding?.btnLogin?.setOnClickListener {

            emailUsed = binding?.email?.editText?.text.toString()
            passwordUsed = binding?.password?.editText?.text.toString()

                val user = runBlocking {
                    userRepo.getUser(emailUsed!!, passwordUsed!!)
                }
                Log.d(TAG, "Values of user $user")
                if  (user?.email != emailUsed && user?.password != passwordUsed){
                    Toast.makeText(this, "User Sign-up required!", Toast.LENGTH_LONG).show()
                }else {
                    val intent = Intent(this, BaseActivity::class.java)

                    startActivity(intent)
                }
        }

        binding?.textViewRegister?.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)

            startActivity(intent)
        }
    }
}