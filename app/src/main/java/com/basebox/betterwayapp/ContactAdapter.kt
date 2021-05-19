package com.basebox.betterwayapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.basebox.betterwayapp.databinding.ContactListItemBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val contacts = mutableListOf<Contact>()

    inner class ContactViewHolder(private  val binding: ContactListItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bindItem(contact: Contact){
            binding.textViewName.text = contact.name
            binding.textViewNumber.text= contact.phone
        }
    }

    fun setUpContacts(contacts: List<Contact>){
        this.contacts.addAll(contacts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(ContactListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bindItem(contact)
    }
}