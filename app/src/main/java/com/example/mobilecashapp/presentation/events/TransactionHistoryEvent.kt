package com.example.mobilecashapp.presentation.events


sealed class TransactionHistoryEvent {
    data object onTransactionHistoryClicked : TransactionHistoryEvent()
}