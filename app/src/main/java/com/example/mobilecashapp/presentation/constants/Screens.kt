package com.example.mobilecashapp.presentation.constants



enum class Graph(val title: String){
    OnBoarding("onboarding"),
    Auth("auth"),
    Home("home")
}

enum class OnBoarding(val route:String) {

    LogoScreen("logo_screen"),
    OnBoarding1("onboarding1"),
    OnBoarding2("onboarding2"),
    OnBoarding3("onboarding3"),

}

enum class Auth(val route: String){
    SignUp("sign_up"),
    Login("login")
}


sealed class Screen(val route:String){
    data object Back: Screen("back")
    data object LogoScreen: Screen("logo_screen")
    data object OnBoarding1: Screen("onboarding1")
    data object OnBoarding2: Screen("onboarding2")
    data object  OnBoarding3: Screen("onboarding3")
    data object SignUp: Screen("sign_up")
    data object Login: Screen("login")
    data object Terms: Screen("terms_and_condition")
    data object ForgetPassword: Screen("forget_password")
    data object SuccessDialog: Screen("success_dialog")
    data object HomeScreen: Screen("home_screen")
    data object Transaction: Screen("transaction")
    data object Wallet: Screen("wallet")
    data object Profile: Screen("profile")
    data object SignUpVerification: Screen("signUp_verification")
    data object ReAuthentication: Screen("reAuthentication")
    data object TransferSuccessful: Screen("transfer_Successful")
    data object TransferFailure: Screen("transfer_Failure")
    data object FailureDialog: Screen("failureDialog")

}