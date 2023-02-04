package com.example.taskasakabank.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskasakabank.R
import com.example.taskasakabank.data.UserCard
import com.example.taskasakabank.data.UserOnlineCard
import com.example.taskasakabank.databinding.ItemOnlineCardVpBinding

class OnlineCardViewPagerRv: ListAdapter<UserOnlineCard, OnlineCardViewPagerRv.ViewHolder>(itemCardsCallback)  {

    inner class ViewHolder(private val binding: ItemOnlineCardVpBinding):RecyclerView.ViewHolder(binding.root){



        fun onBind(){

            val data = getItem(absoluteAdapterPosition)
            binding.apply {
                tvCardTitle.text = data.title
                tvCardDesc.text = data.desc
                colorView.setBackgroundResource(data.color)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return   ViewHolder(
          ItemOnlineCardVpBinding.bind(
              LayoutInflater.from(parent.context).inflate(R.layout.item_online_card_vp,parent,false)
          )
      )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return  holder.onBind()
    }

}


private val itemCardsCallback = object : DiffUtil.ItemCallback<UserOnlineCard>() {
    override fun areItemsTheSame(oldItem: UserOnlineCard, newItem: UserOnlineCard): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserOnlineCard, newItem: UserOnlineCard): Boolean {
        return oldItem.id == newItem.id && oldItem.title == newItem.title && oldItem.desc == newItem.desc && oldItem.color == newItem.color
    }

}