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

class LoginActivity : AppCompatActivity() {
    private val TAG = "LoginActivity"

    private var emailUsed: String? = null
    private var passwordUsed: String? = null

    private var binding: ActivityLoginBinding? = null
    private var email:String?  = null
    private var password:String? = null
    private lateinit var userRepo: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        emailUsed = binding?.email?.editText?.text.toString()
        passwordUsed = binding?.password?.editText?.text.toString()
        email = "martinirex@yahoo.co.uk"
        password = "adminpassword"



        binding?.btnLogin?.setOnClickListener {
       val user = userRepo.getUser(emailUsed!!, passwordUsed!!)
            Log.d(TAG, "Values of userEmail $emailUsed and userPassword $passwordUsed")
            if (user.email != null && user.password != null){
                val intent = Intent(this, BaseActivity::class.java)

                startActivity(intent)

            }else {
                Toast.makeText(this, "User Sign-up required!", Toast.LENGTH_LONG)
            }
        }
    }
}