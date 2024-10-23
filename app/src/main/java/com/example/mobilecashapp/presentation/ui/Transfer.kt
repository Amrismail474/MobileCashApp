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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.Beneficiary
import com.example.mobilecashapp.presentation.viewmodel.MobileCahAppViewModel
import com.example.mobilecashapp.presentation.state.TransferState
import com.example.mobilecashapp.ui.theme.poppinsFontFamily


@Composable
fun Transfer(
    state: TransferState,
    navController: NavController
){
    Scaffold (
        topBar = { GeneralTopAppBar(stringResource(R.string.transfer), navController =navController ) }
    ){paddingValues->
        Column(
            Modifier.fillMaxSize()
                .background(color = colorResource(R.color.background))
                .padding(horizontal = 16.dp, vertical = 24.dp).padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

                TransferCard(state=state)
                TransferRecentRow()
                TransferList()
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferCard(
    modifier: Modifier=Modifier,
    state:TransferState

){
    Card(
        modifier.width(350.dp)
            .height(284.dp)
            ,colors = CardDefaults.cardColors(Color.White)
    ){
        Column (modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){  }
        TextField(
            value =state.amount,
            onValueChange = {},
            modifier.width(320.dp).padding(10.dp),
            placeholder = {
                Text(stringResource(R.string.enter_accountNumer),
                fontSize = 16.sp,
                color = colorResource(R.color.ash),
                fontWeight = FontWeight.Normal,
                fontFamily = poppinsFontFamily)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Blue,
                unfocusedIndicatorColor = Color.Gray,
            )

        )

        Spacer(modifier.height(8.dp))

        TextField(
            value =state.bank,
            onValueChange = {},
            modifier.width(320.dp).padding(10.dp),
            placeholder = {
                Text(stringResource(R.string.selectbank),
                    fontSize = 16.sp,
                    color = colorResource(R.color.ash),
                    fontWeight = FontWeight.Normal,
                    fontFamily = poppinsFontFamily)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Blue,
                unfocusedIndicatorColor = Color.Gray,
            )

        )
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
                    text = stringResource(R.string.next),
                    color = Color.White,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Spacer(modifier.height(96.dp))
    }
}


@Composable
fun TransferRecentRow(
    modifier: Modifier=Modifier
) {

    Row(
        modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,

        ) {

        Text(
            text = (stringResource(R.string.recent)),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = poppinsFontFamily
        )
            Spacer(modifier.weight(1f))

        Text(
            stringResource(R.string.all),
            fontSize = 13.33.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = poppinsFontFamily
        )

        IconButton(onClick = {},modifier.padding()) {
            Icon(
                painterResource(R.drawable.arrow_right),
                contentDescription = null,
                modifier.size(18.dp),
                tint = Color.Unspecified,

            )

    }
}}

@Composable
fun TransferListTemplate(
    modifier: Modifier=Modifier,
   beneficiary: Beneficiary
){
    Row(
        modifier
            .fillMaxWidth()
            .padding(6.dp)
            .background(colorResource(R.color.background)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Image(
            painter = painterResource( beneficiary.image),
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
                text = beneficiary.name,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontFamily = poppinsFontFamily
            )

            Text(
                text = beneficiary.bank,
                fontSize = 13.33.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontFamily = poppinsFontFamily
            )
        }

    }
    Spacer(Modifier.height(4.dp))
}

@Composable
fun TransferList(){
    val benficiaries = listOf(
        Beneficiary((R.drawable.ellipse_9), "Jacob Janes", "AccessBank", "0431609284", "150", "10"),
        Beneficiary((R.drawable.ellipse_9__1_), "Emily Davis", "GTBank", "0324576291", "300", "12"),
        Beneficiary((R.drawable.ellipse_9), "Michael Smith", "ZenithBank", "0218493047", "500", "9"),
        Beneficiary((R.drawable.ellipse_9__1_), "Sophia Adams", "UBA", "0147385649", "200", "8"),
        Beneficiary((R.drawable.ellipse_9), "David Brown", "FirstBank", "0437284932", "400", "15"),
        Beneficiary((R.drawable.ellipse_9__1_), "Olivia White", "UnionBank", "0508394721", "250", "7")

    )
    LazyColumn (
        Modifier.background(colorResource(R.color.background)).padding(4.dp)
    ){
        items(benficiaries){beneficiary->
            TransferListTemplate(beneficiary = beneficiary)

        }
    }
}


@Preview
@Composable
fun TransferPreview(){
    val viewmodel: MobileCahAppViewModel = hiltViewModel()
    val state = viewmodel.transferstate.collectAsState()
    val navController:NavController= rememberNavController()
    Transfer(state.value,navController)

}