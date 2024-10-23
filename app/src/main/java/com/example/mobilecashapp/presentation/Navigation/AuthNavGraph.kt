package com.example.mobilecashapp.presentation.Navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mobilecashapp.presentation.constants.Auth
import com.example.mobilecashapp.presentation.viewmodel.ForgetPasswordViewModel
import com.example.mobilecashapp.presentation.constants.Graph
import com.example.mobilecashapp.presentation.viewmodel.LoginViewModel
import com.example.mobilecashapp.presentation.viewmodel.ReAuthenticationViewModel
import com.example.mobilecashapp.presentation.constants.Screen
import com.example.mobilecashapp.presentation.viewmodel.SignUpViewModel
import com.example.mobilecashapp.presentation.ui.ForgetPassword
import com.example.mobilecashapp.presentation.ui.Login
import com.example.mobilecashapp.presentation.ui.ReAuthentication
import com.example.mobilecashapp.presentation.ui.SignUp
import com.example.mobilecashapp.presentation.ui.TermsAndCondition

fun NavGraphBuilder.authGraph(

    navController: NavController
){

    navigation(
        startDestination = Auth.SignUp.route,
        route = Graph.Auth.title
    ){


        composable(
            route = Screen.SignUp.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { 300 }, animationSpec = tween(600)) + fadeIn(animationSpec = tween(600))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -300 }, animationSpec = tween(600)) + fadeOut(animationSpec = tween(600))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -300 }, animationSpec = tween(600)) + fadeIn(animationSpec = tween(600))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { 300 }, animationSpec = tween(600)) + fadeOut(animationSpec = tween(600))
            }
        ){
            val viewmodel: SignUpViewModel = hiltViewModel()
            val state = viewmodel.signUpUiState.collectAsState()
            SignUp(state.value, viewmodel::signUpEvent,navController)
        }


        composable(
            route = Screen.Login.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { 300 }, animationSpec = tween(600)) + fadeIn(animationSpec = tween(600))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -300 }, animationSpec = tween(600)) + fadeOut(animationSpec = tween(600))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -300 }, animationSpec = tween(600)) + fadeIn(animationSpec = tween(600))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { 300 }, animationSpec = tween(600)) + fadeOut(animationSpec = tween(600))
            }
        ){
            val viewmodel: LoginViewModel = hiltViewModel()
            val state = viewmodel.loginUiState.collectAsState()
            Login(state.value, viewmodel::loginEvent,navController)
        }

        composable(
            route= Screen.Terms.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { 300 }, animationSpec = tween(600)) + fadeIn(animationSpec = tween(600))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -300 }, animationSpec = tween(600)) + fadeOut(animationSpec = tween(600))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -300 }, animationSpec = tween(600)) + fadeIn(animationSpec = tween(600))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { 300 }, animationSpec = tween(600)) + fadeOut(animationSpec = tween(600))
            }
        )
        {
                TermsAndCondition(navController)
            }

        composable(
            route= Screen.ForgetPassword.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { 300 }, animationSpec = tween(600)) + fadeIn(animationSpec = tween(600))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -300 }, animationSpec = tween(600)) + fadeOut(animationSpec = tween(600))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -300 }, animationSpec = tween(600)) + fadeIn(animationSpec = tween(600))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { 300 }, animationSpec = tween(600)) + fadeOut(animationSpec = tween(600))
            }
        ){

            val viewmodel: ForgetPasswordViewModel = hiltViewModel()
            val state = viewmodel.forgetpassword.collectAsState()

                ForgetPassword(state.value,viewmodel::forgetPasswordEvent)
            }


        composable(
            route= Screen.ReAuthentication.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { 300 }, animationSpec = tween(600)) + fadeIn(animationSpec = tween(600))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -300 }, animationSpec = tween(600)) + fadeOut(animationSpec = tween(600))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -300 }, animationSpec = tween(600)) + fadeIn(animationSpec = tween(600))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { 300 }, animationSpec = tween(600)) + fadeOut(animationSpec = tween(600))
            }
        ){
            val viewmodel: ReAuthenticationViewModel = hiltViewModel()
            val state = viewmodel.reAuthenticationUiState.collectAsState()

            ReAuthentication(state.value,viewmodel::reAuthenticationEvent,navController)

        }



    }
}