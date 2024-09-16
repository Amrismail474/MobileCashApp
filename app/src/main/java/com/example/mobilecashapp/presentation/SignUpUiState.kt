package com.example.mobilecashapp.presentation

data class SignUpUiState (
    val phoneNumber:String = "",
    val password : String ="",
    val Name : String="",
    val confirmPassword : String="",
    val passwordVisible: Boolean = false,
    val SignUpchecked : Boolean = false,
    val loginSwitch:Boolean=true,
    val SignUpSwitch : Boolean=false,
    var onRememberPassword : Boolean = false
)