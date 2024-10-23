package com.example.mobilecashapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mobilecashapp.presentation.state.TransactionSuccessfulState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TransfersucessfulViewModel ():ViewModel(){
    val _transactionSuccessful = MutableStateFlow(TransactionSuccessfulState())
    val transactionSuccessful = _transactionSuccessful.asStateFlow()
}