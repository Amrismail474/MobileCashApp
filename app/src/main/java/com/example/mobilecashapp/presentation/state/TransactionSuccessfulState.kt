package com.example.mobilecashapp.presentation.state

import com.example.mobilecashapp.R

data class TransactionSuccessfulState(

    val transaction: TransactionsHistory =
        TransactionsHistory(1, R.drawable.ellipse_9,"Jacob Jones","June 28.00:001am", "$-578"),

)