package com.example.mobilecashapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mobilecashapp.presentation.events.ReAuthenticationEvent
import com.example.mobilecashapp.presentation.state.ReAuthenticationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ReAuthenticationViewModel():ViewModel(){
    val _reAutheticationUiState = MutableStateFlow(ReAuthenticationState())
    val reAuthenticationUiState = _reAutheticationUiState.asStateFlow()



    fun reAuthenticationEvent(event: ReAuthenticationEvent){
        when(event){
            ReAuthenticationEvent.OnLoginButtonClicked -> {
                if(ReAuthenticationLogin()){
                    _reAutheticationUiState.update {
                        it.copy(
                            isSuccessDialog = true,
                            isLoginButtonPressed = true
                        )
                    }
                }else{
                    _reAutheticationUiState.update { it.copy(isErrorDialog = true) }
                }

            }


            ReAuthenticationEvent.OnSwitchAccountClicked -> {
                _reAutheticationUiState.update { it.copy(isSwitchAccountClicked = true) }
            }
            ReAuthenticationEvent.onForgetPasswordClicked -> {
                _reAutheticationUiState.update { it.copy(isForgetPasswordClicked = true) }
            }
        }
    }
}


fun ReAuthenticationLogin():Boolean{
    return true
}