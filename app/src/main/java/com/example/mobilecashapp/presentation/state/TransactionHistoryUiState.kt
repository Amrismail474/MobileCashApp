package com.example.mobilecashapp.presentation.state

import com.example.mobilecashapp.R

data class TransactionHistoryUiState(
    val isTransactionHistoryClicked:Boolean = false,
    val transaction : List<TransactionsHistory> = listOf(
        TransactionsHistory(1, R.drawable.ellipse_9,"Jacob Jones","June 28.00:001am", "$-578"),
        TransactionsHistory(2, R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$78"),
        TransactionsHistory(3, R.drawable.ellipse_9,"Jacob Jones","June 28.00:001am", "$-278"
        ),
        TransactionsHistory(4, R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$1578")
    ),
    var Homewallet:Boolean = true,
    var Homehistory : Boolean=false

)