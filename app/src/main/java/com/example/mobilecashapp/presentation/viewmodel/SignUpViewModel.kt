package com.example.mobilecashapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mobilecashapp.presentation.events.SignUpEvent
import com.example.mobilecashapp.presentation.state.SignUpUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor():ViewModel(){

    val _signUpState = MutableStateFlow(SignUpUiState())
    val signUpUiState = _signUpState.asStateFlow()

    fun signUpEvent(event:SignUpEvent){

        when(event){
            is SignUpEvent.OnConfirmPassword -> {
                _signUpState.update { it.copy(confirmPassword = event.confirmPassword) }
            }

            is SignUpEvent.OnNameChanged -> {
                _signUpState.update { it.copy(name = event.name) }

            }
            is SignUpEvent.OnPasswordChanged -> {
                _signUpState.update { it.copy(password = event.password) }
            }
            is SignUpEvent.OnPhoneChanged -> {
                _signUpState.update { it.copy(phoneNumber = event.phoneNumber) }
            }
            is SignUpEvent.OnTermsAcceptedMarked -> {

            }

            SignUpEvent.TogglePasswordVisibility -> TODO()

            SignUpEvent.Login -> {
                _signUpState.update { it.copy(isLoginOnSignupClicked = true) }
            }

            SignUpEvent.OnLoginSwitchButtonClicked -> {
                _signUpState.update {
                    it.copy(
                        loginSwitch = true,
                        signUpSwitch = false
                    )

                }

            }

            SignUpEvent.OnSignUpSwitchButtonClicked -> {
                _signUpState.update { it.copy(loginSwitch = false) }
                _signUpState.update { it.copy(signUpSwitch = true) }
            }

            SignUpEvent.SignUp -> {
                if(signUp()){
                    Log.d("signup","yes")
                    _signUpState.update { it.copy(isSignUpSuccessful =true) }
                }
            }

            SignUpEvent.OnTermsAndConditionCLicked -> {
                _signUpState.update { it.copy(onTermAndConditionCLicked = true) }
            }

        }

    }





    fun signUp():Boolean{
        Log.d("signup", "Signup logic executed")
        return true
    }

}