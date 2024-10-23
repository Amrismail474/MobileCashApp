package com.example.mobilecashapp.presentation.state

data class ResetPasswordUiState(
    val confirmPassword:String = "",
    val password : String ="",
    val passwordVisible : Boolean = true,
    )