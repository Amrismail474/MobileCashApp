package com.example.mobilecashapp.presentation.events


sealed class ProfileEvent {
    data object OnEditProfileClicked:ProfileEvent()
    data object OnSettingClicked:ProfileEvent()
    data object OnDarkModeClicked:ProfileEvent()
    data object OnHelpAndSupportClicked:ProfileEvent()
    data object OnTermsAndConditionClicked:ProfileEvent()
    data object OnSignOutCLicked:ProfileEvent()
}