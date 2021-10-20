package com.example.myapplication

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {}

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersListView : MvpView {
    fun init()
    fun updateList()
}

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserDescriptionView: MvpView{
    fun init()
    fun updateList()
}



//@AddToEndSingle
//interface ListUserView : MvpView {
//    fun init()
//    fun updateList()
//}
