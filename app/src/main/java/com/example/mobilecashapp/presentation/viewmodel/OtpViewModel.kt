package com.example.mobilecashapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mobilecashapp.presentation.events.OtpUiEvent
import com.example.mobilecashapp.presentation.state.OtpUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OtpViewModel : ViewModel(){

    val _otp = MutableStateFlow(OtpUiState())
    val otp = _otp.asStateFlow()

    fun Onevent(event: OtpUiEvent){

    }


}

