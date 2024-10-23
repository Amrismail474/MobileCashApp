package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.Transaction
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

val transaction =
    Transaction("Kaylin", "5000","8-2-24","000085752257","Card")

@Composable
fun Reciept(modifier: Modifier=Modifier){
    Column (
        modifier
            .fillMaxSize()
            .background(colorResource(R.color.background)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        RecieptCard()
        Spacer(modifier.height(16.dp))
        Button(
            onClick = {  },
            modifier = Modifier
                .width(350.dp)
                .height(52.dp)
                .border(
                    width = 5.dp,
                    color = colorResource(R.color.red).copy(alpha = 0.3f),
                    shape = RoundedCornerShape(60.dp)
                ).padding(4.dp),
            shape = RoundedCornerShape(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent, contentColor = Color.White
            ),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier.background(colorResource(R.color.red))
                    .fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.backtohome),
                    color = Color.White,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}




@Composable
fun RecieptCard(
    modifier: Modifier=Modifier){


    Card(
       modifier.width(348.dp)
           .height(645.04.dp)
           .padding(16.dp),
        colors = CardDefaults.cardColors(Color.White)
    ){
            Column (
                modifier.padding(16.dp)
                    .fillMaxWidth().fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier.height(20.dp))
                Icon(
                    painter = painterResource(R.drawable.successfullfirework),
                    contentDescription = "Successful",
                    modifier.width(68.53.dp).height(68.53.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier.height(4.dp))

                Text(
                    text = stringResource(R.string.paymentSuccessful),
                    fontSize = 23.04.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.AppBlack),

                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.paymentSuccessfulsubtitle),
                    fontSize = 13.33.sp,
                    fontFamily = nunitosansFamily,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(R.color.ash),

                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(R.string.totalpayement),
                    fontSize = 16.sp,
                    fontFamily = nunitosansFamily,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(R.color.AppBlack),

                )


                Text(
                    text ="$${transaction.amount}",
                    fontSize = 27.65.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.AppBlack),

                )

                Spacer(modifier = Modifier.height(32.dp))

                RecieptTemplate(
                    stringResource(R.string.refNumber),
                    transaction.refNumber,
                    stringResource(R.string.paymentTime),
                    transaction.date
                )

                Spacer(modifier = Modifier.height(22.dp))

                RecieptTemplate(
                    stringResource(R.string.paymentMethod),
                    transaction.paymentMethod,
                    stringResource(R.string.senderName),
                    transaction.sender
                )
                Spacer(modifier = Modifier.height(22.dp))

                Divider(Modifier.width(280.dp))

                Spacer(modifier = Modifier.height(16.dp))

                GetReciept()
            }


    }

}

@Composable
fun RecieptTemplate(
    title1:String,
    subtitle1:String,
    title2:String,
    subtitle2:String
){
    Row(
        Modifier.fillMaxWidth().padding(10.dp),
    ){
        Column(

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = title1,
                fontSize = 18.1.sp,
                fontFamily = nunitosansFamily,
                fontWeight = FontWeight.Light,
                color = colorResource(R.color.ash),

                )

            Spacer(Modifier.height(8.dp))

            Text(
                text = subtitle1,
                fontSize = 13.33.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = colorResource(R.color.AppBlack),

                )
        }
        Spacer(Modifier.weight(1f))

        Column(Modifier.padding(end=8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = title2,
                fontSize = 18.1.sp,
                fontFamily = nunitosansFamily,
                fontWeight = FontWeight.Light,
                color = colorResource(R.color.ash),

                )
            Spacer(Modifier.height(8.dp))

            Text(
                text = subtitle2,
                fontSize = 13.33.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = colorResource(R.color.AppBlack),

                )
        }
    }
}

@Composable
fun GetReciept(){
    Box(Modifier.width(209.43.dp).height(46.09.dp), contentAlignment = Alignment.Center){
        Row (
            Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painterResource(R.drawable.resource_import),
                contentDescription = "Download",
                tint = Color.Unspecified
            )
            Spacer(Modifier.width(8.dp))

            Text(
                text = stringResource(R.string.getReciept),
                fontSize = 16.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.AppBlack),

                )

        }
    }
}


@Preview
@Composable
fun ReciptPreview(){
    Reciept()
}