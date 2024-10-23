package com.example.mobilecashapp.presentation.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.Screen
import com.example.mobilecashapp.ui.theme.MobileCashAppTheme
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun OnBoardingTwoMain(
    navController: NavController
){
    Scaffold{ paddingValues->
        Box(Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(colorResource(R.color.background)),
            contentAlignment = Alignment.Center){

        }
            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.offset(y = 20.dp)
            ){
                OnBoardingTwoImage()
                Spacer(Modifier.height(10.dp))
                OnBoardingTwoSectionTwo()
                Spacer(Modifier.height(10.dp))
                OnBoardingTwoSectionThree{
                    navController.navigate(Screen.OnBoarding3.route){
                        popUpTo(Screen.LogoScreen.route) {
                            inclusive = true
                        }
                    }
                }
        }
    }

}


@Composable
fun OnBoardingTwoImage(){
    Box(modifier =
    Modifier
        .width(486.dp)
        .height(180.dp)
        .offset(-30.dp, 30.dp),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(R.drawable.onboardingtwoimage),
            contentDescription = null,
            Modifier.width(486.dp)
                .height(180.dp).padding(start = 80.dp))

    }
}


@Composable
fun OnBoardingTwoSectionTwo(){
    Box(
        Modifier
        .padding(end=14.dp).offset(y=30.dp), contentAlignment = Alignment.Center){
        Image(
            painterResource(R.drawable.eclipse_circle),
            contentDescription = "Eclipse Circle",
            alignment = Alignment.Center,modifier= Modifier.size(496.dp,496.dp)

        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            Text(
                text = stringResource(R.string.onboardingtwoText),
                fontSize = 23.04.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 1.dp),
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFontFamily,
                color = Color(0xFFDD2626),
                textAlign = TextAlign.Left
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(R.string.onboardingSubtitle),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 1.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = nunitosansFamily,
                color = Color.Gray,
                textAlign = TextAlign.Left
            )
        }
    }
}

@Composable
fun OnBoardingTwoSectionThree(
    onSkipOnBaoarding2Clciked:()->Unit
){
    Box(modifier = Modifier.padding(16.dp).fillMaxWidth()){

//        Box(
//            modifier = Modifier
//                .size(72.dp)
//                .align(Alignment.BottomStart)
//                .offset(y = (-80).dp)
//        ){
//            Image(
//                painterResource(R.drawable.ellipse_half),
//                contentDescription = "dn",
//               Modifier.width(49.dp).height(96.dp)
//                       .offset(x=35.dp,y=(-2).dp).size(49.dp)
//            )
//            Image(
//                painterResource(R.drawable.arrow),
//                contentDescription = null,
//                Modifier
//                    .padding(16.dp)
//            )
//
//

//        }

        Box(
            modifier = Modifier
                .size(98.dp)
                .align(Alignment.BottomStart)
                .offset(y = (-80).dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painterResource(R.drawable.ellipse_22),
                contentDescription = "dn",
               Modifier.width(98.dp).height(98.dp)
         )

            Image(
                painter = painterResource(R.drawable.ellipse_8),
                contentDescription = null,
                Modifier
                    .width(64.dp)
                    .height(64.dp).padding(4.dp),
                contentScale = ContentScale.Crop
            )
            Icon(
                (painterResource(R.drawable.full_arrow_right)),
                contentDescription = null,
                Modifier.size(22.dp),
                tint = Color.White
            )


        }

        Box(
            Modifier
                .clickable {
                    Log.d("Onboarding", "Skip clicked")
                    onSkipOnBaoarding2Clciked() }
                .align(Alignment.BottomEnd)
                .offset(y =(-100).dp)
                .width(40.dp).height(70.dp),
            contentAlignment = Alignment.Center
        ){

            Text(
                text = stringResource(R.string.skip),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFFDD2626),
//                modifier = Modifier
//                    .padding(end = 24.dp, bottom = 19.dp)
//                    .align(Alignment.BottomEnd).offset(x = (280).dp)
                modifier=Modifier.clickable { onSkipOnBaoarding2Clciked() }
            )}


    }


}

@Composable
@Preview
fun OPreview(){
    MobileCashAppTheme {
        val navController:NavController= rememberNavController()
       OnBoardingTwoMain(navController)
}}
