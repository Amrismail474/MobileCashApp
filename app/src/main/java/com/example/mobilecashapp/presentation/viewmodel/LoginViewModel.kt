package com.example.mobilecashapp.presentation.viewmodel
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mobilecashapp.presentation.events.LoginEvent
import com.example.mobilecashapp.presentation.state.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel(): ViewModel(){

    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState = _loginUiState.asStateFlow()

    fun loginEvent(event: LoginEvent){
        when(event){
            is LoginEvent.OnPhoneChanged -> {
                _loginUiState.update { it.copy(phoneNumber = event.phone) }
            }
            is LoginEvent.OnPasswordChanged -> {
                _loginUiState.update { it.copy(password = event.password) }
            }
            is LoginEvent.OnRememberPassword -> {
                _loginUiState.update { it.copy(onRememberPasswordchecked = event.checked) }
            }
            LoginEvent.TogglePasswordVisibility -> {
                _loginUiState.update { it.copy(passwordVisible = true) }
            }

            LoginEvent.Login -> {
                if(login()){
                    _loginUiState.update {
                        it.copy(
                            showSuccessDialog = true,
                            isLoggedInSuccessful = true,
                        )
                    }

                }else{

                    _loginUiState.update {
                        it.copy(
                            showFailureDialog = true
                        )
                    }
                    Log.d("error", _loginUiState.value.showFailureDialog.toString())
                }
            }
            LoginEvent.OnSignUpButtonClicked ->{
                _loginUiState.update { it.copy(signUpSwitch = true) }
            }
            LoginEvent.SignUp -> {
                _loginUiState.update { it.copy(onSignUpOnLoginClicked = true) }
            }
            LoginEvent.Terms ->{
                _loginUiState.update { it.copy(onTermsClicked = true) }
            }
            LoginEvent.OnForgetPasswordCLicked -> {
                _loginUiState.update { it.copy(onForgetPasswordClicked = true) }
            }

            LoginEvent.OnLoginButtonClicked -> {
                _loginUiState.update { it.copy(loginSwitch = true) }
            }
        }
    }


    fun login():Boolean{
        return true
    }

}