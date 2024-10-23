package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralTopAppBar(
    title:String,
    navController: NavController,
){
    CenterAlignedTopAppBar(
        title = {

                Text(
                    title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 19.2.sp,
                    color = colorResource(R.color.AppBlack),
                    fontFamily = poppinsFontFamily,
                )
            }
        ,
        Modifier.fillMaxWidth()
            .padding(4.dp)
            .background(colorResource(R.color.background)),

        navigationIcon = {

                Box(
                    modifier = Modifier
                        .clickable { navController.popBackStack() }
                        .padding(start = 16.dp)
                        .width(52.dp)
                        .height(52.dp)
                    ,
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.ellipse_7__2_),
                        contentDescription = null,
                        Modifier
                            .width(52.dp)
                            .height(52.dp),
                    )

                    Image(
                        painter = painterResource(R.drawable.ellipse_8),
                        contentDescription = null,
                        Modifier
                            .width(40.dp)
                            .height(40.dp),
                        contentScale = ContentScale.Crop
                    )
                    Icon(
                        (painterResource(R.drawable.topbar_arrow_left)),
                        contentDescription = null,
                        Modifier.size(20.dp),
                        tint = Color.White
                    )


                }


        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = colorResource(R.color.background)
        )
    )
}