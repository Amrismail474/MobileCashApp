package com.example.mobilecashapp.presentation.state

data class LoginUiState (
        val phoneNumber:String = "",
        val password : String ="",
        val checked : Boolean = false,
        val signUpSwitch : Boolean=false,
        val loginSwitch : Boolean = false,
        val passwordVisible : Boolean = true,
        val onRememberPasswordchecked : Boolean = false,
        val isLoggedInSuccessful : Boolean = false,
        val onSignUpOnLoginClicked : Boolean = false,
        val onTermsClicked:Boolean = false,
        val onForgetPasswordClicked:Boolean=false,
        val isLoading : Boolean = false,
        val showSuccessDialog:Boolean = false,
        val showFailureDialog:Boolean = false,

        )