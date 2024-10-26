package com.example.mobilecashapp.presentation.state

data class ForgetpasswordUiState(
    val phoneNumber: String = "",
    val isContinueButtonCLicked : Boolean = false,
    val isCancelButtonCLicked:Boolean = false,
)