package com.example.mobilecashapp.presentation

data class LoginUiState (
        val phoneNumber:String = "",
        val password : String ="",
        val checked : Boolean = false,
        val loginSwitch:Boolean=true,
        val SignUpSwitch : Boolean=false,
        val passwordVisible : Boolean = false,
        var onRememberPasswordchecked : Boolean = false
        )