package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavOptionsBuilder
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.Graph
import com.example.mobilecashapp.presentation.constants.Screen
import com.example.mobilecashapp.ui.theme.MobileCashAppTheme
import kotlinx.coroutines.delay


@Composable
fun LogoScreen(
    modifier: Modifier=Modifier,
    onNavigationGraph:(Graph, NavOptionsBuilder.()->Unit)->Unit={ _, _ ->}
){

    LaunchedEffect(Unit) {
        delay(3000)
        onNavigationGraph(Graph.OnBoarding){
            popUpTo(Screen.LogoScreen.route)
        }
    }

    
    Box(contentAlignment = Alignment.Center,
        modifier =  modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))){

        Row (modifier=modifier.fillMaxWidth().height(100.dp),

            horizontalArrangement = Arrangement.Center,

            verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(R.drawable.group_66_svg),
                    contentDescription = "Mobile Cash",
                    modifier.width(251.32.dp).height(61.83.dp)

                    )
        }


    }
}

@Preview
@Composable
fun Previw(){
    MobileCashAppTheme {
        LogoScreen()
    }
}
