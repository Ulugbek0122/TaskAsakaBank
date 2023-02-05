package com.example.taskasakabank.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginStart
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskasakabank.R
import com.example.taskasakabank.data.UserCard
import com.example.taskasakabank.databinding.ItemCardsRvBinding

class CardListAdapter : ListAdapter<UserCard, CardListAdapter.ViewHolder>(itemCardsCallback) {

    private var onClickListener: ((UserCard) -> Unit)? = null

    fun setOnClickListener(block: (UserCard) -> Unit) {
        onClickListener = block
    }

    inner class ViewHolder(private val binding: ItemCardsRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.cardItem.setOnClickListener {
                val data = getItem(absoluteAdapterPosition)
                onClickListener?.invoke(data)
            }
        }

        @SuppressLint("ResourceAsColor")
        fun onBind() {
            val data = getItem(absoluteAdapterPosition)
            binding.apply {
                if (itemCount - 1 == absoluteAdapterPosition) {
                    cardItem.setCardBackgroundColor(R.color.color_add_card)
                    cardItem.alpha = .38f
                    bgImage.visibility = View.INVISIBLE
                    logotipCard.setImageResource(data.logotip)
                    numberCard.visibility = View.INVISIBLE
                    tvCurrency.visibility = View.INVISIBLE
                    moneyIsCard.textSize = 10f
                    moneyIsCard.text = data.money
                    moneyIsCard.alpha = 1f
                    moneyIsCard.setTextColor(Color.WHITE)
                }  else {
                    logotipCard.setImageResource(data.logotip)
                    numberCard.text = data.number.toString()
                    moneyIsCard.text = data.money
                    bgImage.setImageResource(data.img)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCardsRvBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_cards_rv, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()
}

private val itemCardsCallback = object : DiffUtil.ItemCallback<UserCard>() {
    override fun areItemsTheSame(oldItem: UserCard, newItem: UserCard): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserCard, newItem: UserCard): Boolean {
        return oldItem.img == newItem.img && oldItem.money == newItem.money && oldItem.number == newItem.number
    }

}