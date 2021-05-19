package com.basebox.betterwayapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.basebox.betterwayapp.databinding.CategoryListItemBinding

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val mCategory: List<Category>? = null

    private val category = mutableListOf<Category>()
    var onItemClick: ((Category) -> Unit)? = null

    inner class CategoryViewHolder(private  val binding: CategoryListItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bindItem(category: Category){
            binding.textViewCategory.text = category.name
        }
        init {
            binding.textViewCategory.setOnClickListener {
                onItemClick?.invoke(category[adapterPosition])
            }
        }
    }

    fun setUpCategories(){
        category.add(Category("Family"))
        category.add(Category("Friends"))
        category.add(Category("Mentors"))

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(CategoryListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun getItemCount(): Int {
        return category.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val cat = category[position]
        holder.bindItem(cat)

    }
}