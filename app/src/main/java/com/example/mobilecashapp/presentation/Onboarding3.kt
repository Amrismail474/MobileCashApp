package com.example.mobilecashapp.presentation
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.MobileCashAppTheme
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun OnBoardingThreeMain(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        contentAlignment = Alignment.Center){
        Column (
        ){
            OnBoardingThreeImage()
            OnBoardingThreeSectionTwo()
            OnBoardingThreeSectionThree()
        }
    }

}


@Composable
fun OnBoardingThreeImage(){
    Box(modifier =
    Modifier
        .width(486.dp)
        .height(180.dp)
        .offset(-30.dp, 30.dp),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(R.drawable.onboardingthreeimage),
            contentDescription = null,
            Modifier.width(486.dp)
                .height(180.dp).padding(start = 80.dp))

    }
}


@Composable
fun OnBoardingThreeSectionTwo(){
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
                text = stringResource(R.string.onboardingthreeText),
                fontSize = 23.04.sp,
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFontFamily,
                color = Color(0xFFDD2626),
                textAlign = TextAlign.Left
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.onboardingSubtitle),
                modifier = Modifier.padding(16.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                textAlign = TextAlign.Left
            )
        }
    }
}

@Composable
fun OnBoardingThreeSectionThree(){
    Box(modifier = Modifier.padding(16.dp).fillMaxWidth()){

        Box(
            modifier = Modifier
                .size(72.dp)  // Adjust the size as per the design
                .align(Alignment.BottomStart)  // Align to bottom-left
                .offset(y = (-80).dp)
        ){
            Image(
                painterResource(R.drawable.circlewitharrow),
                contentDescription = "dn",


                )
            Image(
                painterResource(R.drawable.arrow),
                contentDescription = null,
                Modifier
                    .padding(16.dp)
            )


            Text(
                text = stringResource(R.string.skip),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFFDD2626),
                modifier = Modifier
                    .padding(end = 24.dp, bottom = 19.dp)
                    .clickable {  }
                    .align(Alignment.BottomEnd).offset(x = (280).dp)


            )
        }

    }


}

@Composable
@Preview
fun previewThree(){
    MobileCashAppTheme {
        Box(Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
            contentAlignment = Alignment.Center){
            Column (
                modifier = Modifier.offset(y = 50.dp)
            ){
                OnBoardingThreeImage()
                OnBoardingThreeSectionTwo()
                OnBoardingThreeSectionThree()
            }

        }
    }}
