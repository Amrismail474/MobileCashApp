package com.example.mobilecashapp.presentation.events

sealed class ReAuthenticationEvent{
    data object OnLoginButtonClicked:ReAuthenticationEvent()
    data object onForgetPasswordClicked:ReAuthenticationEvent()
   data object OnSwitchAccountClicked : ReAuthenticationEvent()
}