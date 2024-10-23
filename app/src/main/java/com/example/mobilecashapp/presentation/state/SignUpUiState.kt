package com.example.mobilecashapp.presentation.state

data class SignUpUiState (
    val phoneNumber:String = "",
    val password : String ="",
    val name : String="",
    val confirmPassword : String="",
    val passwordVisible: Boolean = true,
    val signUpChecked : Boolean = false,
    val loginSwitch:Boolean=false,
    val signUpSwitch : Boolean=true,
    var onRememberPassword : Boolean = false,
    val isSignUpSuccessful:Boolean = false,
    val isLoginOnSignupClicked:Boolean=false,
    val onTermAndConditionCLicked:Boolean =false
)