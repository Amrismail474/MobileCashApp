package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun DeleteAccountComponent(
    modifier: Modifier=Modifier
){
    Column (
        modifier.fillMaxSize().background(colorResource(R.color.background)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        DeleteComponent1()
        DeleteComponent2()
        DeleteComponent3()

    }
}

@Composable
fun DeleteComponent1(modifier: Modifier=Modifier){

    Image(
        painter = painterResource(R.drawable.deleteaccountimage),
        contentDescription ="Delete Account",
        modifier.padding(top=20.dp)
    )

}


@Composable
fun DeleteComponent2(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
    Text(
        text = stringResource(R.string.deleteaccount),
        fontSize = 23.04.sp,
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        color = colorResource(R.color.AppBlack),
        textAlign = TextAlign.Center
    )
        Spacer(Modifier.height(8.dp))
    Text(
        text = stringResource(R.string.deleteaccountsubtitle1),
        fontSize = 13.33.sp,
        fontFamily = nunitosansFamily,
        fontWeight = FontWeight.Normal,
        color = colorResource(R.color.AppBlack),
        textAlign = TextAlign.Center,

    )

}}

@Composable
fun DeleteComponent3(

){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Button(
            onClick = { },
            modifier = Modifier
                .width(350.dp)
                .height(52.dp)
                .border(
                    width = 5.dp,
                    color = colorResource(R.color.red).copy(alpha = 0.3f),
                    shape = RoundedCornerShape(60.dp)
                ) .padding(4.dp),

            shape = RoundedCornerShape(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        SolidColor(colorResource(R.color.red)),
                        shape = RoundedCornerShape(60.dp)
                    ).clip(RoundedCornerShape(60.dp))
                    .fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.deleteaccounttext),
                    color = Color.White,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }


        Button(
            onClick = { },
            modifier = Modifier
                .width(350.dp)
                .height(52.dp)
                .border(
                    width = 5.dp,
                    color = colorResource(R.color.white).copy(alpha = 0.3f),
                    shape = RoundedCornerShape(60.dp)
                ) .padding(4.dp),

            shape = RoundedCornerShape(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = colorResource(R.color.red)
            ),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        SolidColor(Color.White),
                        shape = RoundedCornerShape(60.dp)
                    ).clip(RoundedCornerShape(60.dp))
                    .fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.back),
                    color = colorResource(R.color.red),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewDeleteAccont(){

    DeleteAccountComponent()
}
