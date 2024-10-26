package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.R

@Composable
fun ComingSoon(
    navController: NavController
){
    Scaffold(
        topBar = { GeneralTopAppBar("", navController) }
    ) {paddingValues->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.background))
                .padding(horizontal = 6.dp, vertical = 2.dp).padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            ComingSoonContent()
        }

    }
}


@Composable
fun ComingSoonContent(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(R.drawable.coming_soon),
            contentDescription = "Coming Soon"
        )
    }
}

@Preview
@Composable
fun ComingSoonPreview(){
    val navController:NavController= rememberNavController()
    ComingSoon(navController)
}