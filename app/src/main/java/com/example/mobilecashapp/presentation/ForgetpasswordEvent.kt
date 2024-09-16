package com.example.mobilecashapp.presentation

sealed class ForgetpasswordEvent {
    data class onPhoneNumberChanged(val number:String):ForgetpasswordEvent()
    data object continu : ForgetpasswordEvent()
    data object cancel : ForgetpasswordEvent()
}