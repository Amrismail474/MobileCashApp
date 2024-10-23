package com.example.mobilecashapp.presentation.events

sealed class OtpUiEvent{
    data class onOtpEntered(val otp:String) : OtpUiEvent()
    data class onNumbereEntered(val number:String):OtpUiEvent()
    data object OtpCompleted : OtpUiEvent()
    data object onDeleteClicked : OtpUiEvent()
}