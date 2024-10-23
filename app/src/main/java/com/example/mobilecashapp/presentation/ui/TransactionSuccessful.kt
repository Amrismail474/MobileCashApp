package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.viewmodel.MobileCahAppViewModel
import com.example.mobilecashapp.presentation.events.TransactionSuccessfulEvent
import com.example.mobilecashapp.presentation.state.TransactionSuccessfulState
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun TransactionSuccessful(
    state: TransactionSuccessfulState,

){
    Scaffold {innerPadding->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.background))
            .padding(innerPadding)
           .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        TransactionSuccessfulTopAppBarSection()
        SuccessfulIconSection(state)
        Spacer(Modifier.height(16.dp))
        TroubleWithAccount(
            onTrobuleWithAccountClicked = {}
        )
        Spacer(Modifier.height(8.dp))
        DoneButton {  }
    }

}}






@Composable
fun TransactionSuccessfulTopAppBarSection(
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
                (painterResource(R.drawable.topbar_arrow_left)),
                contentDescription = null,
                Modifier.size(20.dp),
                tint = Color.White
            )


        }


        Box (
            contentAlignment = Alignment.TopCenter
        ){

            Text(
                stringResource(R.string.transactionSuccessful),
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
fun SuccessfulIconSection(
    state:TransactionSuccessfulState,
){

    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .width(330.dp)
            .height(625.dp)
//                .wrapContentHeight()
    ) {

        Card(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .width(318.dp)
                .height(635.dp)
            ,
            colors = CardDefaults.cardColors(
                containerColor = Color.White)
            ,
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 36.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.checkmark),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(72.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.successTransaction),
                    fontSize = 11.11.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.TransactionAsh),
                    textAlign = TextAlign.Center
                )


                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = state.transaction.amount,
                    fontSize = 23.04.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.Pgreen),
                    textAlign = TextAlign.Center
                )


                Spacer(modifier = Modifier.height(24.dp))

                Card(
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .width(272.dp)
                        .height(400.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {

                    Row(
                    Modifier.fillMaxWidth().padding( 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,

                    ) {

                    Text(
                        text = (stringResource(R.string.paymentDetail)),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = poppinsFontFamily
                    )
                }

                    PaymentDetailSection(state)

                }


            }


        }



        }


}




@Composable
fun PaymentDetailSection(
    state: TransactionSuccessfulState
){
    Column(modifier = Modifier.padding( 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        PaymentDetailItem(label = "Transfer to", value = "Naura Alisa",isBold = true)
        PaymentDetailItem(label = "Transaction ID", value = state.transaction.id.toString())
        PaymentDetailItem(label = "Date Payment", value = state.transaction.date)
        PaymentDetailItem(label = "Payment Status", value = "Success")
        Divider(Modifier.height(1.dp))
        PaymentDetailItem(label = "Transaction Type", value = "Transfer")
        PaymentDetailItem(label = "Nominal", value = state.transaction.date)
        PaymentDetailItem(label = "Tax", value = "Success")
        PaymentDetailItem(label = "Total Payment", value = state.transaction.amount, isBold = true)

    }

}

@Composable
fun TroubleWithAccount(
    modifier: Modifier = Modifier,
    onTrobuleWithAccountClicked:(TransactionSuccessfulEvent)->Unit
) {
    Text(
        text = stringResource(R.string.trobulewithyouraccount),
        modifier.clickable {
            onTrobuleWithAccountClicked(TransactionSuccessfulEvent.onTrobuleWithAccountClicked)
        },
        color = Color.Red,

    )
}

@Composable
fun PaymentDetailItem(label: String, value: String, isBold: Boolean = false) {
    Row() {
        Text(
            text = label,
            fontSize = 13.33.sp,
            fontFamily = nunitosansFamily,
            fontWeight =  if (isBold)FontWeight.Bold else FontWeight.Normal,
            color = colorResource(R.color.TransactionAsh),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.weight(1f))

        Text(
            text = value,
            fontSize = 13.33.sp,
            fontFamily = nunitosansFamily,
            fontWeight = if (isBold)FontWeight.Bold else FontWeight.Normal,
            color = colorResource(R.color.TransactionAsh),

            )
    }
}


@Composable
fun DoneButton(
    onTransactionDoneButtonCLicked:(TransactionSuccessfulEvent)->Unit
){
    Button(
        onClick = { onTransactionDoneButtonCLicked(TransactionSuccessfulEvent.onTransactionDoneButtonCLicked) },
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
                text = stringResource(R.string.Done),
                color = Color.White,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Composable
@Preview
fun TransactionSuccessfulPreview(){

        val viewmodel: MobileCahAppViewModel = hiltViewModel()
        val state = viewmodel.transactionSuccessful.collectAsState()

        TransactionSuccessful(state.value)

}