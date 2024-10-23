package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.viewmodel.MobileCahAppViewModel
import com.example.mobilecashapp.presentation.state.TransactionConfirmationState
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily







@Composable
fun TransferConfirmation(
    modifier: Modifier=Modifier,
    state:TransactionConfirmationState
){
    var balance= (state.benficiary.amount).toInt()-(state.benficiary.fee).toInt()

    Card(modifier.width(318.dp).height(535.dp),
        colors = CardDefaults.cardColors(colorResource(R.color.background)),
        shape = RoundedCornerShape(25.dp),

    ){
        Column(
            modifier
                .fillMaxSize()
                .padding(4.dp)
                .background(colorResource(R.color.background)),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PaymentText(state.benficiary.amount)
            InnerCard1(state=state)
            Spacer(modifier.height(8.dp))
            InnerCard3(
                profilePicture = state.benficiary.image,
                balance = balance.toString()
            )

            Spacer(modifier.height(8.dp))
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
                        text = stringResource(R.string.confirmtopay),
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

}


@Composable
fun PaymentText(
    amount:String
){
    Column(
        Modifier.fillMaxWidth().padding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Box(Modifier.width(80.dp)){}
            Text(
                text = stringResource(R.string.payment),
                Modifier.align(Alignment.CenterVertically),
                fontSize = 19.2.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFontFamily
            )

            Box(Modifier.width(30.dp)){}

            IconButton(
                onClick ={}
            ) {
                Icon(
                    painter = painterResource(R.drawable.cancel_red),
                    contentDescription = "Show Password",
                    Modifier.size(40.dp),
                    tint= Color.Unspecified
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        Box(
            Modifier.width(185.dp).height(72.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "$${amount}",
                fontSize = 47.78.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFontFamily
            )

        }

        Spacer(Modifier.height(10.dp))


    }

}



@Composable
fun InnerCard1(modifier: Modifier=Modifier,
               state:TransactionConfirmationState){
    Card(
        modifier.width(286.dp).height(176.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(15.dp)
    ){

        Column (
            modifier.fillMaxSize().fillMaxWidth().padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            InnerCard1Template(name=state.benficiary.name, bank = state.benficiary.bank, profilePicture = state.benficiary.image)
            Spacer(modifier.height(4.dp))
            Divider(modifier.width(254.dp))
            Spacer(modifier.height(4.dp))
            InnerCard2(
                stringResource(R.string.amount),
                state.benficiary.amount)

            InnerCard2(
                stringResource(R.string.fee),
                state.benficiary.fee)

            InnerCard2(
                stringResource(R.string.accountNumber),
                state.benficiary.accountNumber)
        }

    }
}

@Composable
fun InnerCard1Template(
    modifier: Modifier=Modifier,
    name: String,
    bank:String,
    profilePicture:Int,
){
    Row(
        modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Image(
            painter = painterResource(profilePicture),
            contentDescription = "User Profile",
            modifier
                .size(50.dp)
                .background(
                    color = Color.Unspecified,
                    shape = CircleShape
                ),
            contentScale = ContentScale.Fit
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 12.dp)
        ) {
            Text(
                text = name,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFontFamily
            )

            Text(
                text = bank,
                fontSize = 13.33.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontFamily = nunitosansFamily
            )
        }
    }
}

@Composable
fun InnerCard2(
    title:String,
    text:String
){
    Row(
        Modifier.fillMaxWidth().padding(2.dp),
    ){

            Text(
                text = title,
                Modifier.weight(1f),
                fontSize = 18.1.sp,
                fontFamily = nunitosansFamily,
                fontWeight = FontWeight.Light,
                color = colorResource(R.color.ash),

                )


            Text(
                text = "$${text}",
                fontSize = 18.1.sp,
                fontFamily = nunitosansFamily,
                fontWeight = FontWeight.Light,
                color = colorResource(R.color.ash),

                )
    }
}

@Composable
fun InnerCard3(
    modifier: Modifier=Modifier,
    profilePicture:Int,
    balance:String
){
    Card(
        modifier.width(286.dp).height(64.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(15.dp)
    ){
        Row(
            modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Image(
                painter = painterResource(profilePicture),
                contentDescription = "User Profile",
                modifier
                    .size(50.dp)
                    .background(
                        color = Color.Unspecified,
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "(${stringResource(R.string.balance)}: ${balance})",
                fontSize = 13.33.sp,
                color = colorResource(R.color.ash),
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFontFamily
            )

        }
    }

}

@Preview
@Composable
fun TPreview(){
    val viewmodel: MobileCahAppViewModel = hiltViewModel()
    val state = viewmodel.transferconfirmation.collectAsState()
    TransferConfirmation(state=state.value)
}