package com.example.mobilecashapp.presentation.events

sealed class ResetPasswordEvent {

    data class OnConfirmPasswordChanged(val confirmpassword:String) : ResetPasswordEvent()
    data class OnPassword(val password:String): ResetPasswordEvent()
    data object TogglePasswordVisibility: ResetPasswordEvent()
    data object continu : ResetPasswordEvent()
    data object cancel : ResetPasswordEvent()

}