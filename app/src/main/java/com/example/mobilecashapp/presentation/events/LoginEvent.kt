package com.example.mobilecashapp.presentation.events

sealed class LoginEvent {
    data class OnPhoneChanged(val phone:String) : LoginEvent()
    data class OnPasswordChanged(val password:String): LoginEvent()
    data class OnRememberPassword(val checked:Boolean): LoginEvent()
    data object OnSignUpButtonClicked : LoginEvent()
    data object OnLoginButtonClicked:LoginEvent()
    data object TogglePasswordVisibility: LoginEvent()
    data object OnForgetPasswordCLicked:LoginEvent()
    data object SignUp: LoginEvent()
    data object  Login: LoginEvent()
    data object  Terms : LoginEvent()
}