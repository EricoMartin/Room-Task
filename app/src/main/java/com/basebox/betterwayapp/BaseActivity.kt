package com.basebox.betterwayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.basebox.betterwayapp.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity(){

    private  lateinit var binding: ActivityBaseBinding
    private val adapter = CategoryAdapter()

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

            setUpData(binding)
    }

    private fun setUpData(binding: ActivityBaseBinding) {
        binding.recycledBaseView.adapter = adapter
        GridLayoutManager(
            this, // context
            2, // span count
            RecyclerView.VERTICAL, // orientation
            false // reverse layout
        ).apply {
            // specify the layout manager for recycler view
            binding.recycledBaseView.layoutManager = this
        }
        binding.recycledBaseView.addItemDecoration(DividerItemDecoration(this, GridLayout.VERTICAL))

        adapter.setUpCategories()
        adapter.onItemClick = {
            when (it.name) {
                "Family" -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                }
                "Friends" -> {
                    val intent = Intent(this, FriendsActivity::class.java)
                    startActivity(intent)

                }
                else -> {
                    val intent = Intent(this, MentorsActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}