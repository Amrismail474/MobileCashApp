package com.example.mobilecashapp.presentation.state

import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.User

data class ReAuthenticationState (
    val isPasswordVisible:Boolean = true,
    val password:String="",
    val user: User =
        User("David","Oyedipo",R.drawable.user_placeholder,
            "aaismail201@gmail.com","08034567238","0431609284","18,952.7"),

    val isLoginButtonPressed:Boolean=false,
    val isForgetPasswordClicked:Boolean = false,
    val isSwitchAccountClicked :Boolean = false,
    val isSuccessDialog:Boolean=false,
    val isErrorDialog:Boolean=false,

    )