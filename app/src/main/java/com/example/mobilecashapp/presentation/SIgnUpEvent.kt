package com.example.mobilecashapp.presentation

sealed class SignUpEvent {
    data class OnNameChanged(val email:String) : SignUpEvent()
    data class OnPasswordChanged(val password:String):SignUpEvent()
    data class OnPhoneChanged(val phoneNumber: String):SignUpEvent()
    data class OnConfirmPassword(val confirmPassword: String):SignUpEvent()
    data class OnTermsAcceptedChanged(val marked:Boolean):SignUpEvent()
    data object TogglePasswordVisibility:SignUpEvent()
    data object signUp: SignUpEvent()
    data object  login: SignUpEvent()

}