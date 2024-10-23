package com.example.mobilecashapp.presentation.events

sealed interface TransactionSuccessfulEvent {
    data object onTrobuleWithAccountClicked : TransactionSuccessfulEvent
    data object onTransactionDoneButtonCLicked:TransactionSuccessfulEvent
}