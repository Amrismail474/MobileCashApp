package com.example.mobilecashapp.presentation.events

sealed interface TransactionFailedEvent {
    data object onTrobuleWithAccountClicked : TransactionFailedEvent
    data object onTransactionDoneButtonCLicked:TransactionFailedEvent
}