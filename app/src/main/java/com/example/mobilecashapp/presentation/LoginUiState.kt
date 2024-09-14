package com.example.mobilecashapp.presentation

data class LoginUiState (
        val phoneNumber:String = "",
        val password : String ="",
        val checked : Boolean = true,
        val loginSwitch:Boolean=true,
        val SignUpSwitch : Boolean=false,
        var onRememberPassword : Boolean = false
        )