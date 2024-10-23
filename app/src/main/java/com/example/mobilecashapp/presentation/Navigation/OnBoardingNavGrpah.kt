package com.example.mobilecashapp.presentation.Navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mobilecashapp.presentation.constants.Graph
import com.example.mobilecashapp.presentation.constants.OnBoarding
import com.example.mobilecashapp.presentation.ui.OnBoardingOneMain
import com.example.mobilecashapp.presentation.ui.OnBoardingThreeMain
import com.example.mobilecashapp.presentation.ui.OnBoardingTwoMain

fun NavGraphBuilder.onBoardingGraph(
    navController: NavController
){

    navigation(
        startDestination = OnBoarding.OnBoarding1.route,
        route = Graph.OnBoarding.title
    ){


        composable(route= OnBoarding.OnBoarding1.route,

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

            OnBoardingOneMain(navController)
        }

        composable(route = OnBoarding.OnBoarding2.route,

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
            OnBoardingTwoMain(navController)
        }

        composable(route = OnBoarding.OnBoarding3.route,
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
            OnBoardingThreeMain(navController)
        }


    }

}