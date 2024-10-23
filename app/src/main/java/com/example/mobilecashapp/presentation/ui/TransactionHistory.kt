package com.example.mobilecashapp.presentation.ui

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.Screen
import com.example.mobilecashapp.presentation.events.TransactioEvent
import com.example.mobilecashapp.presentation.events.TransactionHistoryEvent
import com.example.mobilecashapp.presentation.state.TransactionHistoryUiState
import com.example.mobilecashapp.presentation.state.TransactionsHistory
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

val TransactionList = listOf(
    TransactionsHistory(1,R.drawable.ellipse_9,"Jacob Jones","June 28.00:001am", "$-578"),
    TransactionsHistory(2,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$78"),
    TransactionsHistory(3,R.drawable.ellipse_9,"Jacob Jones","June 28.00:001am", "$-278"
    ),
    TransactionsHistory(4,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$1578")
)


@Composable
fun Transaction(
    navController: NavController,
    state:TransactionHistoryUiState,
    event:(TransactionHistoryEvent)->Unit
){

    LaunchedEffect(state.isTransactionHistoryClicked){
        if(state.isTransactionHistoryClicked){
            navController.navigate(Screen.TransferSuccessful.route)
        }
    }

    Scaffold(
        topBar = { GeneralTopAppBar(stringResource(R.string.transaction), navController) }
    ) { paddingValues->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.background))
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
//            TransactionTopAppBarSection()
            DualTransactionButton(
                state=state,
                event= event,
                onWalletTabClicked = {})
        }
    }
}


//@Composable
//fun TransactionTopAppBarSection(
//    modifier: Modifier = Modifier
//) {
//    Row(
//        modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .background(colorResource(R.color.background)),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//
//        Box(
//            modifier = Modifier
//                .size(72.dp)
//                .padding(8.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            Image(
//                painter = painterResource(R.drawable.ellipse_7__2_),
//                contentDescription = null,
//                Modifier
//                    .width(52.dp)
//                    .height(52.dp),
//            )
//
//            Image(
//                painter = painterResource(R.drawable.ellipse_8),
//                contentDescription = null,
//                Modifier
//                    .width(40.dp)
//                    .height(40.dp),
//                contentScale = ContentScale.Crop
//            )
//            Icon(
//                (painterResource(R.drawable.arrow_right)),
//                contentDescription = null,
//                Modifier.size(20.dp),
//                tint = Color.White
//            )
//
//
//        }
//
//
//        Box (
//            contentAlignment = Alignment.TopCenter
//        ){
//
//            Text(
//                stringResource(R.string.transaction),
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 19.2.sp,
//                color = colorResource(R.color.AppBlack),
//                fontFamily = poppinsFontFamily,
//            )
//        }
//
//
//        Box(
//            modifier = Modifier.size(72.dp)
//        ) {}
//
//    }
//}

@Composable
fun DualTransactionButton(
    modifier: Modifier=Modifier,
    state: TransactionHistoryUiState,
    onWalletTabClicked:(TransactioEvent)->Unit,
    event:(TransactionHistoryEvent)->Unit
) {


    Row(
        Modifier
            .width(138.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(R.color.red).copy(alpha = 0.3f),
                        colorResource(R.color.red).copy(alpha = 0.3f)
                    )
                )
            ),

        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        val BaseModifiers = Modifier
            .width(60.dp)
            .height(24.dp)
            .clip(RoundedCornerShape(15.dp))


        Box(
            modifier = BaseModifiers
                .background(if (state.Homewallet) colorResource(R.color.red) else Color.Transparent)
                .clickable {
                    onWalletTabClicked((TransactioEvent.onWalletTabPressed))
                }
            ,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.wallet),
                fontWeight = FontWeight.Normal,
                fontSize = 11.11.sp,
                color = Color.White,
                fontFamily = nunitosansFamily,

                )
        }
        Spacer(Modifier.width(5.dp))

        Box(
            modifier = BaseModifiers
                .background(if (state.Homehistory) colorResource(R.color.red) else Color.Transparent)
              ,
            contentAlignment = Alignment.Center
        ) {
            Text(
                stringResource(R.string.history),
                fontWeight = FontWeight.Normal,
                fontSize = 11.11.sp,
                color = Color.White,
                fontFamily = nunitosansFamily,

                )
        }
    }


    Spacer(Modifier.height(16.dp))

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),

    ) {

        item {
            Text(
                stringResource(R.string.Today),
                color = colorResource(R.color.AppBlack),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = poppinsFontFamily,
                textAlign = TextAlign.Start
            )
        }
        items(TransactionList){item->
            FullTransactionTemplate(modifier,item.name,
                item.date,item.image,item.amount,
                event = event
            )


        }

}

    Spacer(Modifier.height(16.dp))

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),

        ) {
        val TransactionList = listOf(
            TransactionsHistory(1,R.drawable.ellipse_9,"Jacob Jones","June 28.00:001am", "$-578"),
            TransactionsHistory(2,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$78"),
            TransactionsHistory(3,R.drawable.ellipse_9,"Jacob Jones","June 28.00:001am", "$-278"
            ),
            TransactionsHistory(4,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$1578")
        )
        item {
            Text(
                stringResource(R.string.yesterday),
                color = colorResource(R.color.AppBlack),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = poppinsFontFamily,
                textAlign = TextAlign.Start
            )
        }
        items(TransactionList){item->
            FullTransactionTemplate(modifier,item.name,item.date,item.image,item.amount,event)


        }

    }

}


@Composable
fun FullTransactionTemplate(
    modifier: Modifier=Modifier,
    name: String,
    timeAndDate:String,
    profilePicture:Int,
    amount:String,
    event:(TransactionHistoryEvent)->Unit
){
    Row(
        modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(colorResource(R.color.background)).clickable {
                event(TransactionHistoryEvent.onTransactionHistoryClicked)
            },
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
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = name,
                fontSize = 13.33.sp,
                color = colorResource(R.color.AppBlack),
                fontWeight = FontWeight.Normal,
                fontFamily = poppinsFontFamily
            )

            Text(
                text = timeAndDate,
                fontSize = 13.33.sp,
                color = colorResource(R.color.AppBlack),
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFontFamily
            )
        }

        Spacer(Modifier.weight(1f))

        Text(
            text = amount,
            fontSize = 13.33.sp,
            color = if (amount.filter { it.isDigit() || it == '-' }.toInt() > 1)
                colorResource(R.color.Pgreen)
            else
                colorResource(R.color.red),
            fontWeight = FontWeight.Normal,
            fontFamily = poppinsFontFamily
        )
    }}

@Composable
@Preview
fun TransactionPreview(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.background))
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
//        TransactionTopAppBarSection()
//        DualTransactionButton(state, event = {}, onWalletTabClicked = {})
    }

}

