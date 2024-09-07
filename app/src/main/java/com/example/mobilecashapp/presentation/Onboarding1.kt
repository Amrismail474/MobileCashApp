package com.example.mobilecashapp.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
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
fun OnBoardingOneMain(){
    Box(Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Color.White),
        contentAlignment = Alignment.Center){
        Column (
            modifier = Modifier.offset(y = 50.dp)
        ){
            OnBoardingOneImage()
            //OnBoardingTextOne()
            OnBoardingCSectionTwo()
            OnBoardingOneSectionThree()
        }
    }

}


@Composable
fun OnBoardingOneImage(){
    Box(modifier =
    Modifier
        .width(486.dp)
        .height(180.dp)
        .offset(0.dp, 0.dp),
        contentAlignment = Alignment.Center
    ){
            Image(painter = painterResource(R.drawable.group_34212),
                contentDescription = "onboardingimage",
                Modifier.width(486.dp)
                    .height(180.dp).padding(start = 80.dp))

    }
}


@Composable
fun OnBoardingCSectionTwo(){
    Box(Modifier
        .padding(end=14.dp), contentAlignment = Alignment.Center){
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
                text = stringResource(R.string.onboardingText),
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
fun OnBoardingOneSectionThree(){
    Box(modifier = Modifier.padding(16.dp).fillMaxWidth()){

            Box(
                modifier = Modifier
                    .size(72.dp)  // Adjust the size as per the design
                    .align(Alignment.BottomStart)  // Align to bottom-left
                    .offset(y = (-120).dp)
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
                    .padding(end = 24.dp, bottom = 16.dp)
                    .clickable {  }
                    .align(Alignment.BottomEnd).offset(x = (280).dp)


            )}

    }


}

@Composable
fun SignupScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FD))
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Canvas for Circular Graphics
            Canvas(
                modifier = Modifier.size(300.dp)
            ) {
                // Draw outer circle
                drawArc(
                    color = Color(0xFFDD2626),
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    topLeft = Offset(0f, size.height / 2 - 150f),
                    size = Size(size.width, size.height),
                    style = Stroke(width = 4.dp.toPx())
                )

                // Draw inner circle
                drawArc(
                    color = Color(0xFFDD2626),
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    topLeft = Offset(20f, size.height / 2 - 130f),
                    size = Size(size.width - 40f, size.height - 40f),
                    style = Stroke(width = 4.dp.toPx())
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Sign up now and get\n500 Naira bonus instantly!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFDD2626),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Join Mobile Cash now and experience\ntrue money freedom with seamless\ntransactions",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }

        // Circular Button with arrow
        Box(
            modifier = Modifier
                .size(72.dp)
                .align(Alignment.BottomStart)
                .padding(bottom = 16.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Color(0xFFDD2626), Color(0xFF0033A0)),
                        radius = 150f
                    ),
                    shape = CircleShape
                )
                .clickable { /* Handle click */ },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_24), // Use your arrow icon resource
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }

        // Skip Text
        Text(
            text = "Skip",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFDD2626),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 32.dp)
                .clickable { /* Handle skip action */ }
        )
    }
}



@Composable
@Preview
fun Preview(){
    MobileCashAppTheme {
        Box(Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
            contentAlignment = Alignment.Center){
            Column (
                modifier = Modifier.offset(y = 50.dp)
            ){
                OnBoardingOneImage()
                //OnBoardingTextOne()
                OnBoardingCSectionTwo()
                OnBoardingOneSectionThree()
            }
        }
       
    }
}