package com.example.mobilecashapp.presentation.events

sealed class SignUpEvent {
    data class OnNameChanged(val name:String) : SignUpEvent()
    data class OnPasswordChanged(val password:String): SignUpEvent()
    data class OnPhoneChanged(val phoneNumber: String): SignUpEvent()
    data class OnConfirmPassword(val confirmPassword: String): SignUpEvent()
    data class OnTermsAcceptedMarked(val marked:Boolean): SignUpEvent()
    data object OnTermsAndConditionCLicked:SignUpEvent()
    data object OnLoginSwitchButtonClicked: SignUpEvent()
    data object OnSignUpSwitchButtonClicked:SignUpEvent()
    data object TogglePasswordVisibility: SignUpEvent()
    data object SignUp: SignUpEvent()
    data object  Login: SignUpEvent()

}