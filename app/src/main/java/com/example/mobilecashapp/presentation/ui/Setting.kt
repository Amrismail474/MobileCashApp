package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun SettingTopbar(
    modifier: Modifier = Modifier
){

    Row(
        modifier
            .fillMaxWidth()
            .padding(top=8.dp)
            .background(colorResource(R.color.background)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Box (
            contentAlignment = Alignment.TopCenter
        ){

            Text(
                stringResource(R.string.setting),
                fontWeight = FontWeight.SemiBold,
                fontSize = 19.2.sp,
                color = colorResource(R.color.AppBlack),
                fontFamily = poppinsFontFamily,
            )
        }

    }

}


@Composable
fun SettingContainer(modifier: Modifier= Modifier){
    Column(
        modifier.padding(top=16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
    SettingTemplate(
        icon=painterResource(R.drawable.security_user),
        title = stringResource(R.string.accountsecurity),
        subtitle = stringResource(R.string.accountsecuritysubtitle)
    )
    SettingTemplate(
        icon=painterResource(R.drawable.arrow_swap),
        title = stringResource(R.string.transactionpin),
        subtitle = stringResource(R.string.transactionpinsubtitle)
    )
    SettingTemplate(
        icon=painterResource(R.drawable.delete),
        title = stringResource(R.string.deleteaccount),
        subtitle = stringResource(R.string.deleteaccountsubtitle)
    )
    }
}

@Composable
fun SettingTemplate(
    modifier: Modifier=Modifier,
    icon: Painter,
    title:String,
    subtitle:String
)

{
    Row(
        modifier
            .fillMaxWidth()
            .padding()
            .background(colorResource(R.color.background)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier
                .size(72.dp)
                .padding(start =4.dp),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(R.drawable.ellipse_7__2_),
                contentDescription = null,
                modifier = Modifier
                    .width(52.dp)
                    .height(52.dp),
            )

            Image(
                painter = painterResource(R.drawable.ellipse_8),
                contentDescription = null,
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                contentScale = ContentScale.Crop
            )
            Icon(
                icon,
                contentDescription = null,
                tint = Color.White
            )

        }
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontFamily = poppinsFontFamily
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = subtitle,
                fontSize = 13.33.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontFamily = nunitosansFamily
            )


        }


        Spacer(Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(
                painterResource(R.drawable.halfarrow_right),
                contentDescription = null,
                tint = colorResource(R.color.red)
            )
        }




    }}



@Composable
@Preview
fun SettingsPreview(){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SettingTopbar()
        SettingContainer()

    }
}