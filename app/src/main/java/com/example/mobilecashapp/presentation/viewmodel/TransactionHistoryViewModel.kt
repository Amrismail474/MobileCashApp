package com.example.mobilecashapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mobilecashapp.presentation.events.TransactionHistoryEvent
import com.example.mobilecashapp.presentation.state.TransactionHistoryUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TransactionHistoryViewModel (): ViewModel(){

    val _transactionHistory = MutableStateFlow(TransactionHistoryUiState())
    val transactionHistory = _transactionHistory.asStateFlow()

    fun event(event:TransactionHistoryEvent){
        when(event){
            TransactionHistoryEvent.onTransactionHistoryClicked -> {
                _transactionHistory.update { it.copy(isTransactionHistoryClicked = true) }
            }
        }

    }



}