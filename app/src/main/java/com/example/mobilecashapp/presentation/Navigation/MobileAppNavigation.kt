package com.example.mobilecashapp.presentation.Navigation

import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.presentation.ui.GeneralTopAppBar
import com.example.mobilecashapp.presentation.ui.LogoScreen
import com.example.mobilecashapp.presentation.constants.Graph
import com.example.mobilecashapp.presentation.constants.OnBoarding
import com.example.mobilecashapp.presentation.constants.Screen

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController()
){

    val onNavigationChanged:(Screen, NavOptionsBuilder.()->Unit)->Unit={
        screen, builder ->
        when(screen){
            Screen.Back-> navController.navigateUp()

            else-> navController.navigate(screen.route){
                builder.invoke(this)
            }
            }
        }


    val onNavigationGraph:(Graph, NavOptionsBuilder.()->Unit)->Unit={
        graph, builder ->
        navController.navigate(graph.title){
            builder.invoke(this)
        }
    }





    NavHost(navController, startDestination = OnBoarding.LogoScreen.route) {

        composable(route= OnBoarding.LogoScreen.route,
            enterTransition = {
                fadeIn(animationSpec = tween(300, easing = LinearEasing)) +
                        slideInHorizontally(animationSpec = tween(300, easing = EaseIn))
            }){
//            LogoScreen(
//                onNavigateToOnboarding1 = {
//                    navController.navigate(Graph.OnBoarding.name)
//                }
//            )
            LogoScreen(onNavigationGraph = onNavigationGraph)
        }

        composable(Screen.Back.route){
            GeneralTopAppBar("",navController)
        }





        onBoardingGraph(navController)
        authGraph(navController)
        homeGraph(navController)




    }
}