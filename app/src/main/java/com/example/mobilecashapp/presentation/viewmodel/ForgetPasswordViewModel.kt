package com.example.mobilecashapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mobilecashapp.presentation.events.ForgetpasswordEvent
import com.example.mobilecashapp.presentation.state.ForgetpasswordUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ForgetPasswordViewModel():ViewModel() {

    val _forgetpassword = MutableStateFlow(ForgetpasswordUiState())
    val forgetpassword = _forgetpassword.asStateFlow()


    fun forgetPasswordEvent(event:ForgetpasswordEvent){
        when(event){
            ForgetpasswordEvent.cancel ->{
                _forgetpassword.update {
                    it.copy(
                        isCancelButtonCLicked = true
                    )
                }
            }
            ForgetpasswordEvent.continu -> {
                _forgetpassword.update {
                    it.copy(
                        isContinueButtonCLicked = true
                    )
                }
            }
            is ForgetpasswordEvent.onPhoneNumberChanged -> TODO()
        }
    }
}