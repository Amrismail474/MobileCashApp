package com.example.mobilecashapp.presentation.state

data class HomeUiState(
    val balance:String="$18,952.87",
    val isWalletCLicked:Boolean = true,
    val isHistoryCLicked : Boolean=false,
    var isBalanceVisible:Boolean=true,
    var isBottomTabActive:Boolean=true,
    var isSeeMoreClicked:Boolean = false,
    var isNotificationIconClicked :Boolean = false
)


data class QuickSendConstants(
    val image: Int,
    val name:String
)

data class TransactionsHistory(
    val id : Int = 1,
    val image: Int,
    val name: String,
    val date:String,
    val amount:String
)

data class BottomNavigationItem(
    val tittle:String,
    val Icon:Int,
    val route:String,

        )