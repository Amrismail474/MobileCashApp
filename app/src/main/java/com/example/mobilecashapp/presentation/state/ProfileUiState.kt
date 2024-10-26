package com.example.mobilecashapp.presentation.state

data class ProfileUiState(
    val title:String="",
    val subtitle:String="",
    val isEditProfileClicked:Boolean=false,
    val isSettingClicked:Boolean=false,
    val isDarkModeClicked:Boolean=false,
    val isHelpAndSupportClicked:Boolean=false,
    val isTermsAndConditionClicked:Boolean=false,
    val isSignOutCLicked:Boolean=false
)