package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily



@Composable
fun HelpAndSupport(){
    Column (
        Modifier.fillMaxSize().background(color = colorResource(R.color.background)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        HelpandsupportTopAppBarSection()
        HelpComponent1()
        HelpComponent2()
    }
}

@Composable
fun HelpandsupportTopAppBarSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(colorResource(R.color.background)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier
                .size(72.dp)
                .padding(8.dp),
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
                (painterResource(R.drawable.arrow_right)),
                contentDescription = null,
                Modifier.size(20.dp),
                tint = Color.White
            )


        }


        Box (
            contentAlignment = Alignment.TopCenter
        ){

            Text(
                stringResource(R.string.helpandsupport),
                fontWeight = FontWeight.SemiBold,
                fontSize = 19.2.sp,
                color = colorResource(R.color.AppBlack),
                fontFamily = poppinsFontFamily,
            )
        }


        Box(
            modifier = Modifier.size(12.dp)
        ) {}

    }
}

@Composable
fun HelpComponent1(modifier: Modifier=Modifier){

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){

            Image(
                painter = painterResource(R.drawable.helpandsupportimage),
                contentDescription ="Delete Account",
                modifier.padding(top=20.dp)
            )
            Spacer(Modifier.height(16.dp))

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
                textAlign = TextAlign.Center
            )

        }


}

@Composable
fun HelpComponent2(){
    Column (){

        HelpTemplate(
            icon = painterResource(R.drawable.helpphone),
            title = stringResource(R.string.faq),
            subtitle = stringResource(R.string.faqsubtitle)
        )
        HelpTemplate(
            icon = painterResource(R.drawable.instagram),
            title = stringResource(R.string.instagram),
            subtitle = stringResource(R.string.instagramsubtitle)
        )
        HelpTemplate(
            icon = painterResource(R.drawable.gmail),
            title = stringResource(R.string.gmail),
            subtitle = stringResource(R.string.gmailsubtitle)
        )
        HelpTemplate(
            icon = painterResource(R.drawable.whatsapp),
            title = stringResource(R.string.whatsapp),
            subtitle = stringResource(R.string.whatsappsubtitle)
        )
        HelpTemplate(
            icon = painterResource(R.drawable.x),
            title = stringResource(R.string.x),
            subtitle = stringResource(R.string.xsubtitle)
        )
    }
}

@Composable
fun HelpTemplate(
    modifier: Modifier=Modifier,
    icon: Painter,
    title:String,
    subtitle:String
)

{

    Row(
        modifier
            .fillMaxWidth()
            .padding(end=4.dp)
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
                painter = painterResource(R.drawable.group_46),
                contentDescription = null,
                modifier = Modifier
                    .width(52.dp)
                    .height(52.dp),
            )
            Icon(
                icon,
                contentDescription = null,
                tint = Color.Unspecified
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
                fontWeight = FontWeight.SemiBold,
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
                    painterResource(R.drawable.export),
                    contentDescription = null
                )

        }


    }}

@Composable
@Preview
fun PreviewHelpAccount(){

    HelpAndSupport()
}
