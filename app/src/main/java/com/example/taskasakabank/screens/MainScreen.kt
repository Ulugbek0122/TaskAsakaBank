package com.example.taskasakabank.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.taskasakabank.R
import com.example.taskasakabank.adapter.*
import com.example.taskasakabank.data.UserCard
import com.example.taskasakabank.data.UserOnlineCard
import com.example.taskasakabank.databinding.ScreenMainBinding
import com.example.taskasakabank.source.LocalDataSource

class MainScreen:Fragment(R.layout.screen_main) {

    private val viewBinding:ScreenMainBinding by viewBinding(ScreenMainBinding::bind)
    private val cardListAdapter:CardListAdapter by lazy { CardListAdapter() }
    private val viewPagerRv:ViewPagerRv by lazy { ViewPagerRv() }
    private val onlineCardViewPagerRv:OnlineCardViewPagerRv by lazy { OnlineCardViewPagerRv() }
    private val categoryAdapter:CategoryAdapter by lazy { CategoryAdapter() }
    private val historyAdapterRv:HistoryAdapterRv by lazy { HistoryAdapterRv() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.rvCardList.adapter = cardListAdapter
        viewBinding.viewPager.adapter  =viewPagerRv
        viewBinding.onlineCardPager.adapter = onlineCardViewPagerRv
        viewBinding.rvCategory.adapter = categoryAdapter
        viewBinding.historyAdapter.adapter = historyAdapterRv


        cardListAdapter.submitList(LocalDataSource.cardList)
        viewPagerRv.submitList(LocalDataSource.balanceList)
        onlineCardViewPagerRv.submitList(LocalDataSource.onlineCardList)
        categoryAdapter.submitList(LocalDataSource.categoryList)
        historyAdapterRv.submitList(LocalDataSource.historyList)

        viewBinding.dotsIndicator.attachTo(viewBinding.viewPager)
        viewBinding.dotsIndicatorOnlineCard.attachTo(viewBinding.onlineCardPager)
    }
}

