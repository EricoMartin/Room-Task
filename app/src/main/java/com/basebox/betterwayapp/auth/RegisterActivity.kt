package com.basebox.betterwayapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.basebox.betterwayapp.BaseActivity
import com.basebox.betterwayapp.databinding.ActivityRegisterBinding
import com.basebox.betterwayapp.db.UserRepository
import com.basebox.betterwayapp.entity.User

class RegisterActivity : AppCompatActivity() {

    private val TAG = "RegisterActivity"

    private var binding: ActivityRegisterBinding? = null
    private var email:String?  = null
    private var password:String? = null
    private lateinit var userRepo: UserRepository
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        userRepo = UserRepository(this)

        email = binding?.email?.editText?.text.toString()
        password = binding?.password?.editText?.text.toString()

        binding?.btnRegister?.setOnClickListener {

            if(email.isNullOrBlank() && password.isNullOrBlank()){
                Toast.makeText(this, "Email and Password Required!", Toast.LENGTH_LONG)
            }else{
                val user = User(0, email, password)
                userRepo.addUser(user)

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
            }
        }
    }
}