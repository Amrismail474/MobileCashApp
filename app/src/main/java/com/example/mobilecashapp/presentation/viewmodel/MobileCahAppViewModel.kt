package com.example.mobilecashapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mobilecashapp.presentation.events.ForgetpasswordEvent
import com.example.mobilecashapp.presentation.events.HomeEvent
import com.example.mobilecashapp.presentation.events.LoginEvent
import com.example.mobilecashapp.presentation.events.ResetPasswordEvent
import com.example.mobilecashapp.presentation.events.SignUpEvent
import com.example.mobilecashapp.presentation.events.TransactionFailedEvent
import com.example.mobilecashapp.presentation.events.TransactionSuccessfulEvent
import com.example.mobilecashapp.presentation.state.ForgetpasswordUiState
import com.example.mobilecashapp.presentation.state.HomeUiState
import com.example.mobilecashapp.presentation.state.LoginUiState
import com.example.mobilecashapp.presentation.state.OtpUiState
import com.example.mobilecashapp.presentation.state.ReAuthenticationState
import com.example.mobilecashapp.presentation.state.ResetPasswordUiState
import com.example.mobilecashapp.presentation.state.ResetState
import com.example.mobilecashapp.presentation.state.SignUpUiState
import com.example.mobilecashapp.presentation.state.TransactionConfirmationState
import com.example.mobilecashapp.presentation.state.TransactionFailedState
import com.example.mobilecashapp.presentation.state.TransactionSuccessfulState
import com.example.mobilecashapp.presentation.state.TransferState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MobileCahAppViewModel():ViewModel() {

    val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState = _loginUiState.asStateFlow()

    val _signUpStatec = MutableStateFlow(SignUpUiState())
    val signUpUiState = _signUpStatec.asStateFlow()

    val _forgetpassword = MutableStateFlow(ForgetpasswordUiState())
    val forgetpassword = _forgetpassword.asStateFlow()

    val _otp = MutableStateFlow(OtpUiState())
    val otp = _otp.asStateFlow()

    val _resetpassword= MutableStateFlow(ResetPasswordUiState())
    val resetpassword = _resetpassword.asStateFlow()

    val _home = MutableStateFlow(HomeUiState())
    val home = _home.asStateFlow()

    val _transactionSuccessful = MutableStateFlow(TransactionSuccessfulState())
    val transactionSuccessful = _transactionSuccessful.asStateFlow()

    val _transactionFailed = MutableStateFlow(TransactionFailedState())
    val transactionFailed = _transactionFailed.asStateFlow()

    val _transferconfirmation = MutableStateFlow(TransactionConfirmationState())
    val transferconfirmation = _transferconfirmation.asStateFlow()

    val _transferstate = MutableStateFlow(TransferState())
    val transferstate=_transferstate.asStateFlow()

    val _reautheticationstate = MutableStateFlow(ReAuthenticationState())
    val reauthenticationtsate = _reautheticationstate.asStateFlow()

    val _resetState = MutableStateFlow(ResetState())
    val resetState=_resetState.asStateFlow()


    fun OnLoginEvent(loginEvent: LoginEvent){

    }

    fun OnSignupEvent(signUpEvent: SignUpEvent){

    }

    fun OnforgetPassword(forgetpasswordEvent: ForgetpasswordEvent){

    }

    fun OnResetPassword(resetPasswordEvent: ResetPasswordEvent){

    }

    fun OnHomeEvent(homeEvent: HomeEvent){

    }

    fun onTransactionSuccessfulEvent(transactionSuccessfulEvent: TransactionSuccessfulEvent){

    }
    fun onTransactionFailedEvent(transactionFailedEvent: TransactionFailedEvent){

    }
}