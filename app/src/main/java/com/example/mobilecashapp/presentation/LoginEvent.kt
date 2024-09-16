package com.example.mobilecashapp.presentation

sealed class LoginEvent {
    data class OnEmailChanged(val email:String) : LoginEvent()
    data class OnPasswordChanged(val password:String):LoginEvent()
    data class OnRememberPassword(val checked:Boolean):LoginEvent()
    data object TogglePasswordVisibility:LoginEvent()
    data object signUp: LoginEvent()
    data object  login: LoginEvent()
    data object  terms : LoginEvent()




}