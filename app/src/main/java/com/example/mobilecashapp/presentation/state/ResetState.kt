package com.example.mobilecashapp.presentation.state

data class ResetState(
    val confirmPassword:String = "",
    val password : String ="",
    val passwordVisible : Boolean = true,
)