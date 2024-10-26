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
import androidx.navigation.compose.navigation
import com.example.mobilecashapp.presentation.constants.Graph
import com.example.mobilecashapp.presentation.viewmodel.HomeViewModel
import com.example.mobilecashapp.presentation.constants.Screen
import com.example.mobilecashapp.presentation.ui.EditProfile
import com.example.mobilecashapp.presentation.ui.HelpAndSupport
import com.example.mobilecashapp.presentation.viewmodel.TransactionHistoryViewModel
import com.example.mobilecashapp.presentation.viewmodel.TransfersucessfulViewModel
import com.example.mobilecashapp.presentation.ui.Home
import com.example.mobilecashapp.presentation.ui.Profile
import com.example.mobilecashapp.presentation.ui.Setting
import com.example.mobilecashapp.presentation.ui.TermsAndCondition
import com.example.mobilecashapp.presentation.ui.Transaction
import com.example.mobilecashapp.presentation.ui.TransactionSuccessful
import com.example.mobilecashapp.presentation.ui.Wallet
import com.example.mobilecashapp.presentation.viewmodel.ProfileViewModel

fun NavGraphBuilder.homeGraph(
    navController: NavController
){

    navigation(
        startDestination = Screen.HomeScreen.route,
        route= Graph.Home.title
        ){

        composable(
            Screen.HomeScreen.route,
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
            val viewmodel: HomeViewModel = hiltViewModel()
            val state = viewmodel.homeUiState.collectAsState()
            Home(state.value,viewmodel::onEvent,navController)
        }




        composable(
            Screen.Transaction.route,
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
            val viewmodel: TransactionHistoryViewModel = hiltViewModel()
            val state = viewmodel.transactionHistory.collectAsState()
            Transaction(navController,state.value,viewmodel::event)
        }





        composable(route= Screen.TransferSuccessful.route){
            val viewmodel: TransfersucessfulViewModel = hiltViewModel()
            val state = viewmodel.transactionSuccessful.collectAsState()
            TransactionSuccessful(state.value)
        }





        composable(
            Screen.Wallet.route,
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
            Wallet(navController)
        }





        composable(
            Screen.Profile.route,
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
            val viewmodel: ProfileViewModel = hiltViewModel()
            val state = viewmodel.profile.collectAsState()
            Profile(state.value, viewmodel::OnEvent, navController)
        }





        composable(
            Screen.Setting.route,
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
            Setting()
        }






        composable(
            route= Screen.ProfileTerms.route,
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
            route= Screen.EditProfile.route,
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
            EditProfile()
        }





        composable(
            route= Screen.HelpAndSupport.route,
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
            HelpAndSupport()
        }












    }


}