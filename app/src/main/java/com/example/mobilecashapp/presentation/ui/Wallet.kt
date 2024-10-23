package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.mobilecashapp.presentation.state.BottomNavigationItem
import com.example.mobilecashapp.presentation.state.TransactionsHistory
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily


val user = User("AL-HASSAN" ,"SOLATE",R.drawable.ellipse_9,
    "hassansolate202@gmail.com","08052377416","0431609284","18,952.7")


@Composable
fun Wallet(
    navController:NavController
){


    val items = listOf(
        BottomNavigationItem("Home", R.drawable.home_clear,"home_screen"),
        BottomNavigationItem("Wallet", R.drawable.transaction_wallet,"wallet"),
        BottomNavigationItem("Transaction", R.drawable.transaction_icon,"transaction"),
        BottomNavigationItem("Profile", R.drawable.profileicon,"profile"),
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(1)
    }
    Scaffold(
        topBar = {},
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex==index,
                        onClick = {selectedItemIndex = index
                            navController.navigate(item.route)
                                  },
                        icon = {Icon(
                            painterResource( item.Icon),
                            contentDescription = "BottomBar Icons",
                            tint = if(selectedItemIndex==index) Color.Red else Color.Unspecified
                        )},
                        label = {Text(item.tittle)},

                        )

                }
            }

        }
    ) {innerPadding->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .width(390.dp)
                .height(844.dp)
                .background(color = colorResource(R.color.background))
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top)
        {
            WalletTopAppBarSection()
            Spacer(Modifier.height(24.dp))
            WalletSection1(user=user)
            Spacer(Modifier.height(16.dp))
            WalletRecentTransactions()

    }
}}




@Composable
fun WalletTopAppBarSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(colorResource(R.color.background)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .size(72.dp),
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

        Spacer(Modifier.weight(1f))

        Image(
            painter = painterResource(R.drawable.user_placeholder),
            contentDescription = "User Profile",
            modifier
                .size(50.dp)
                .background(
                    color = Color.Unspecified,
                    shape = CircleShape
                ), // Border shape and background color
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.width(12.dp))

    }
}


@Composable
fun WalletSection1(
    modifier: Modifier=Modifier,
    user: User
    ){
    Column(
        modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Text(
           stringResource(R.string.my_wallet),
            fontWeight = FontWeight.Medium,
            fontSize = 33.8.sp,
            color = colorResource(R.color.AppBlack),
            fontFamily = poppinsFontFamily,
        )
        Text(
            stringResource(R.string.currentbalance),
            fontWeight = FontWeight.Medium,
            fontSize = 13.33.sp,
            color = colorResource(R.color.red),
            fontFamily = poppinsFontFamily,
        )

        Text(
            "$${user.balance}",
            fontWeight = FontWeight.Medium,
            fontSize = 33.8.sp,
            color = colorResource(R.color.AppBlack),
            fontFamily = poppinsFontFamily,
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
//            Box(
//                modifier = Modifier
//
//                    .clip(RoundedCornerShape(25.dp))
//                    .border(
//                        width = 5.dp,
//                        color = colorResource(R.color.red).copy(alpha = 0.3f),
//                        shape = RoundedCornerShape(25.dp)
//                    )
//                    .background(colorResource(R.color.red))
//                    .width(100.dp)
//                    .height(45.dp)
//                ,
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = stringResource(R.string.wallet),
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 11.11.sp,
//                    color = Color.White,
//                    fontFamily = nunitosansFamily,
//
//                    )

            Button(onClick = {},
                Modifier
//                    .clip(RoundedCornerShape(25.dp))
////                    .border(
////                        width = 5.dp,
////                        color = colorResource(R.color.red).copy(alpha = 0.3f),
////                        shape = RoundedCornerShape(25.dp)
////                    )
                    .border(
                        width = 5.dp,
                        color = colorResource(R.color.red).copy(alpha = 0.3f),
                        shape = RoundedCornerShape(60.dp))
                    .padding(4.dp)
                    .width(130.dp)
                    .height(56.dp),

                shape = RoundedCornerShape(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.red)
                )) {
                Text(
                   text = stringResource(R.string.wallet),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontFamily = nunitosansFamily,

                    )

            }
            Spacer(modifier.width(12.dp))
            Box(
                modifier = Modifier
                    .width(130.dp)
                    .height(56.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color.White)
                ,
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.fund),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = colorResource(R.color.red),
                    fontFamily = nunitosansFamily,

                    )
            }
        }


    }
}



@Composable
fun WalletRecentTransactions(modifier: Modifier=Modifier){
    Row(
        Modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,

        ) {
        Spacer(Modifier.height(20.dp))
        Text(
            text = (stringResource(R.string.recentActivities)),
            color = colorResource(R.color.AppBlack),
            fontSize = 19.2.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = poppinsFontFamily
        )

        Spacer(Modifier.weight(1f))

        Text(
            text = (stringResource(R.string.see_more)),
            color = colorResource(R.color.AppBlack),
            modifier = Modifier
                .clickable {  },
            fontSize = 13.3.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = poppinsFontFamily
        )
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val items = listOf(
            TransactionsHistory(1,R.drawable.ellipse_9,"Jacob Jones","June 28.00:001am", "$-578"),
            TransactionsHistory(2,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$78"),
            TransactionsHistory(3,R.drawable.ellipse_9,"Jacob Jones","June 28.00:001am", "$-278"
            ),
            TransactionsHistory(4,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$1578"),
            TransactionsHistory(4,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$1578"),
            TransactionsHistory(4,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$1578"),
            TransactionsHistory(4,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$1578"),
            TransactionsHistory(4,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$1578"))

        items(items){item->
            TransactionTemplate(modifier,item.name,item.date,item.image,item.amount)

        }




    }


}


@Preview
@Composable
fun walletPreview(){
    val navController:NavController = rememberNavController()
    Wallet(navController)



}