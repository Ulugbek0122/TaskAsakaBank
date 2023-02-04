package com.example.taskasakabank.source

import com.example.taskasakabank.R
import com.example.taskasakabank.data.*

object LocalDataSource {


    var balanceList = ArrayList<BalanceData>()
    var cardList = ArrayList<UserCard>()
    var onlineCardList = ArrayList<UserOnlineCard>()
    var categoryList = ArrayList<CategoryData>()
    var historyList = ArrayList<HistoryData>()

    init{
        balanceList.add(BalanceData(1,true,"7 265 135"))
        balanceList.add(BalanceData(2,true,"15 437 315"))

        cardList.add(UserCard(1, R.drawable.logotype_uzcard,R.drawable.image_1,7436,"7 265 135"))
        cardList.add(UserCard(2,R.drawable.logotype_humo,R.drawable.image_humo,3322,"15 437 315"))
        cardList.add(UserCard(3,R.drawable.icon__defoult,R.drawable.icon__defoult,3322,"Добавить карту"))

        onlineCardList.add(UserOnlineCard(1,"Виртуальная карта","Для online покупок",R.color.online_card))
        onlineCardList.add(UserOnlineCard(2,"Виртуальная карта","Для online покупок",R.color.online_card2))
        onlineCardList.add(UserOnlineCard(3,"Виртуальная карта","Для online покупок",R.color.online_card3))

        categoryList.add(CategoryData(1,"Korona Pay",R.drawable.logotype_koronapay))
        categoryList.add(CategoryData(2,"MoneySend",R.drawable.logotype_mastercard))
        categoryList.add(CategoryData(3,"Заказать карту",R.drawable.logoty_card))
        categoryList.add(CategoryData(4,"Мой дом",R.drawable.logotype_home))


        historyList.add(HistoryData(1,R.drawable.usell,"93 551 63 24","**** 7436","– 28 000","16:52"))
        historyList.add(HistoryData(1,R.drawable.uscard,"Tugusheva Dinara","**** 7436","– 8 713 700","15:30"))
        historyList.add(HistoryData(1,R.drawable.uscard,"Vernik Igor","**** 7436","+ 13 342 000","5 января"))
        historyList.add(HistoryData(1,R.drawable.humo,"Gelnov Sergey","**** 3322","+ 2 239 300","5 января"))
        historyList.add(HistoryData(1,R.drawable.kfc,"KFC","**** 7436","– 76 000","31 декабря"))
    }
}