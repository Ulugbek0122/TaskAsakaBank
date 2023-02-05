package com.example.taskasakabank.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskasakabank.R
import com.example.taskasakabank.data.CategoryData
import com.example.taskasakabank.data.UserOnlineCard
import com.example.taskasakabank.databinding.ItemCardsRvBinding
import com.example.taskasakabank.databinding.ItemCategoryRvBinding
import com.example.taskasakabank.databinding.ItemOnlineCardVpBinding

class CategoryAdapter: ListAdapter<CategoryData, CategoryAdapter.ViewHolder>(itemCardsCallback)  {

    inner class ViewHolder(private val binding: ItemCategoryRvBinding):RecyclerView.ViewHolder(binding.root){


        init {

        }

        fun onBind(){
            val data = getItem(absoluteAdapterPosition)
            binding.apply {
                imgLogo.setImageResource(data.image)
                titleLogo.text = data.title
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return   ViewHolder(
          ItemCategoryRvBinding.bind(
              LayoutInflater.from(parent.context).inflate(R.layout.item_category_rv,parent,false)
          )
      )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return  holder.onBind()
    }

}


private val itemCardsCallback = object : DiffUtil.ItemCallback<CategoryData>() {
    override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
        return oldItem.id == newItem.id && oldItem.title == newItem.title
    }

}