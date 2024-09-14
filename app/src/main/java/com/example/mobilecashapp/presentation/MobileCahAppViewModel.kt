package com.example.mobilecashapp.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MobileCahAppViewModel():ViewModel() {

    val _createaccountUiState = MutableStateFlow(LoginUiState())
    val createAccountUiState = _createaccountUiState.asStateFlow()

    fun OnEvent(loginEvent: LoginEvent){

    }
}