package com.basebox.betterwayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.basebox.betterwayapp.databinding.ActivityMentorsBinding

class MentorsActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMentorsBinding
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMentorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData(binding)
    }

    private fun setUpData(binding: ActivityMentorsBinding) {

        binding.recyclerViewMentor.adapter = adapter
        binding.recyclerViewMentor.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        val builder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val view =  inflater.inflate(R.layout.add_contact_dialogue, null)
        builder.setView(view)

        val name = view.findViewById<EditText>(R.id.editTextName)
        val number = view.findViewById<EditText>(R.id.editTextPhone)
        val saveBtn = view.findViewById<Button>(R.id.button)

        number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveBtn.isEnabled = s?.length == 11
            }

        })
        val alertDialog = builder.create()

        saveBtn.setOnClickListener {
            val contact = Contact(name.text.toString(), number.text.toString())
            val contacts = mutableListOf(contact)

            adapter.setUpContacts(contacts)
            alertDialog.dismiss()
        }

        binding.floatingActionButton.setOnClickListener{
            alertDialog.show()
        }

    }
}