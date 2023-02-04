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
import com.example.taskasakabank.data.BalanceData
import com.example.taskasakabank.data.UserCard
import com.example.taskasakabank.databinding.ItemBalanseVpBinding

class ViewPagerRv: ListAdapter<BalanceData, ViewPagerRv.ViewHolder>(itemCardsCallback)  {

    inner class ViewHolder(private val binding: ItemBalanseVpBinding):RecyclerView.ViewHolder(binding.root){



        fun onBind(){
            val data = getItem(absoluteAdapterPosition)
            binding.apply {
                imgVisibility.setOnClickListener {
                    if (data.visibility){
                        data.visibility = false
                        tvBalanse.visibility = View.INVISIBLE
                        tvStar.visibility = View.VISIBLE




                        tvCurrency.visibility = View.INVISIBLE
                        imgVisibility.setImageResource(R.drawable.visibl)
                    }else{
                        data.visibility = true
                        tvBalanse.visibility = View.VISIBLE
                        tvStar.visibility = View.INVISIBLE
                        tvCurrency.visibility = View.VISIBLE
                        imgVisibility.setImageResource(R.drawable.icon__11_)
                    }
                }
            }

            binding.apply {
                tvBalanse.text = data.money
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return   ViewHolder(
          ItemBalanseVpBinding.bind(
              LayoutInflater.from(parent.context).inflate(R.layout.item_balanse_vp,parent,false)
          )
      )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return  holder.onBind()
    }

}


private val itemCardsCallback = object : DiffUtil.ItemCallback<BalanceData>() {
    override fun areItemsTheSame(oldItem: BalanceData, newItem: BalanceData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BalanceData, newItem: BalanceData): Boolean {
        return oldItem.money == newItem.money && oldItem.visibility == newItem.visibility
    }

}