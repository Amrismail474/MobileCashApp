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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.User
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun FundWallet(
    navController: NavController
){
    val user = User("AL-HASSAN" ,"SOLATE",
        R.drawable.ellipse_9,"hassansolate202@gmail.com",
        "08052377416","0431609284","18,952.7")

    Scaffold(
        topBar = { GeneralTopAppBar("",navController) }
    ) {paddingValues->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.background))
                .padding(horizontal = 6.dp, vertical = 2.dp).padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            FundWalletCard(user)
        }

    }
}


@Composable
fun FundWalletCard(
    user: User
){
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .width(350.dp)
            .height(146.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.red)
        )
    ){
        Box(
            contentAlignment = Alignment.Center
        ){
            Image(painterResource(R.drawable.wallet_card),
                contentDescription = ""
            )

            Column(
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Row(
                    Modifier.fillMaxWidth().padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "ALHassan Tolani",
                        fontSize = 13.33.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(R.color.white))
                    Spacer(Modifier.weight(1f))

                    Text(
                        stringResource(R.string.mobile_cash),
                        fontSize = 13.33.sp,
                        fontFamily = nunitosansFamily,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(R.color.white))
                }

                Row(
                    Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        stringResource(R.string.mobilecashaccountnumber),
                        fontSize = 13.33.sp,
                        fontFamily = nunitosansFamily,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(R.color.white))
                    Spacer(Modifier.weight(1f))
                    Text(
                        user.accountNumber,
                        fontSize = 13.33.sp,
                        fontFamily = nunitosansFamily,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(R.color.white))
                    Spacer(Modifier.width(2.dp))
                    IconButton(onClick = {}) {
                        Icon(
                            painterResource(R.drawable.copy_icon),
                            contentDescription = "",
                            tint= Color.Unspecified)
                    }

                }

            }

        }


    }
}

@Preview
@Composable
fun FundWalletPreview(){
    val navController:NavController= rememberNavController()
    FundWallet(navController)
}