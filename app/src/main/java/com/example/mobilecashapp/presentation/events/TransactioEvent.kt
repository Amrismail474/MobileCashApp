package com.example.mobilecashapp.presentation.events

sealed class TransactioEvent{
    data object onWalletTabPressed : TransactioEvent()
}