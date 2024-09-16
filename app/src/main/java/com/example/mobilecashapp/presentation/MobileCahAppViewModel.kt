package com.example.mobilecashapp.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MobileCahAppViewModel():ViewModel() {

    val _createaccountUiState = MutableStateFlow(LoginUiState())
    val createAccountUiState = _createaccountUiState.asStateFlow()

    val _signUpStatec = MutableStateFlow(SignUpUiState())
    val signUpUiState = _signUpStatec.asStateFlow()

    val _forgetpassword = MutableStateFlow(ForgetpasswordUiState())
    val forgetpassword = _forgetpassword.asStateFlow()


    fun OnEvent(loginEvent: LoginEvent){

    }

    fun OnSignupEvent(signUpEvent: SignUpEvent){

    }

    fun OnforgetPassword(forgetpasswordEvent: ForgetpasswordEvent){

    }
}