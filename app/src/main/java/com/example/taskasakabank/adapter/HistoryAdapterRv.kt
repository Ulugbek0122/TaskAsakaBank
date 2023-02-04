package com.example.taskasakabank.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskasakabank.R
import com.example.taskasakabank.data.CategoryData
import com.example.taskasakabank.data.HistoryData
import com.example.taskasakabank.data.UserOnlineCard
import com.example.taskasakabank.databinding.ItemCardsRvBinding
import com.example.taskasakabank.databinding.ItemCategoryRvBinding
import com.example.taskasakabank.databinding.ItemHistoryRvBinding
import com.example.taskasakabank.databinding.ItemOnlineCardVpBinding

class HistoryAdapterRv: ListAdapter<HistoryData, HistoryAdapterRv.ViewHolder>(itemCardsCallback)  {

    inner class ViewHolder(private val binding: ItemHistoryRvBinding):RecyclerView.ViewHolder(binding.root){



        fun onBind(){
            val data = getItem(absoluteAdapterPosition)
            binding.apply {
                imageLogo.setImageResource(data.image)
                tvTitle.text = data.title
                tvCardNumber.text = data.cardNumber
                tvBalanse.text = data.balance
                tvTime.text = data.date
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return   ViewHolder(
          ItemHistoryRvBinding.bind(
              LayoutInflater.from(parent.context).inflate(R.layout.item_history_rv,parent,false)
          )
      )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return  holder.onBind()
    }

}


private val itemCardsCallback = object : DiffUtil.ItemCallback<HistoryData>() {
    override fun areItemsTheSame(oldItem: HistoryData, newItem: HistoryData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HistoryData, newItem: HistoryData): Boolean {
        return oldItem.id == newItem.id && oldItem.title == newItem.title && oldItem.image == newItem.image
                && oldItem.cardNumber == newItem.cardNumber
                && oldItem.balance == newItem.balance && oldItem.date == newItem.date
    }

}