package com.example.mobilecashapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mobilecashapp.presentation.events.ForgetpasswordEvent
import com.example.mobilecashapp.presentation.state.ForgetpasswordUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ForgetPasswordViewModel():ViewModel() {

    val _forgetpassword = MutableStateFlow(ForgetpasswordUiState())
    val forgetpassword = _forgetpassword.asStateFlow()


    fun forgetPasswordEvent(event:ForgetpasswordEvent){

    }
}