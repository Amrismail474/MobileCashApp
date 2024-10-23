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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.events.HomeEvent
import com.example.mobilecashapp.presentation.state.HomeUiState
import com.example.mobilecashapp.presentation.viewmodel.MobileCahAppViewModel
import com.example.mobilecashapp.presentation.constants.Screen
import com.example.mobilecashapp.presentation.state.BottomNavigationItem
import com.example.mobilecashapp.presentation.state.QuickSendConstants
import com.example.mobilecashapp.presentation.state.TransactionsHistory
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily


@Composable
fun Home(
    state: HomeUiState,
    event: (HomeEvent)->Unit,
    navController: NavController
){
    val items = listOf(
        BottomNavigationItem("Home", R.drawable.home_clear,"home_screen"),
        BottomNavigationItem("Wallet", R.drawable.transaction_wallet,"wallet"),
        BottomNavigationItem("Transaction", R.drawable.transaction_icon,"transaction"),
        BottomNavigationItem("Profile", R.drawable.profileicon,"profile"),
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    LaunchedEffect(state.isHistoryCLicked){
        if(state.isHistoryCLicked){
            navController.navigate(Screen.Transaction.route)
        }
    }

    LaunchedEffect(state.isSeeMoreClicked){
        if(state.isSeeMoreClicked){
            navController.navigate(Screen.Transaction.route)
        }
    }



    Scaffold(
        topBar = {
          },
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex==index,

                        onClick = {
                            selectedItemIndex = index
                                navController.navigate(item.route){
                                    popUpTo(Screen.HomeScreen.route){
                                        inclusive=false
                                    }
                                }
                                selectedItemIndex=0

                                  },

                        icon = {Icon(
                            painterResource( item.Icon),
                            contentDescription = "BottomBar Icons",
//                            if(selectedItemIndex==index) Color.Red else
                            tint = Color.Unspecified
                        )},
                        colors = NavigationBarItemColors(
                            selectedTextColor = colorResource(R.color.red),
                            selectedIconColor = colorResource(R.color.red),
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor =  Color.Gray,
                            disabledIconColor =  Color.Gray,
                            disabledTextColor =  Color.Gray,
                            selectedIndicatorColor = Color.Unspecified
                        ),
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
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp))
        {
            TopAppBarSection()
            DualHomeButton(state,event)
            Spacer(Modifier.height(1.dp))
            HomeCard(state)
            QuickSend()
            RecentTransactions(event = event)

        }


    }

}





@Composable
fun TopAppBarSection(
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
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = (stringResource(R.string.welcome)),
                fontSize = 13.33.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontFamily = poppinsFontFamily
            )

            Text(
                text = "Al-Hassan",
                fontSize = 13.33.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFontFamily
            )
        }
        Spacer(Modifier.weight(1f))

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
                (painterResource(R.drawable.notification_bing)),
                contentDescription = null,
                Modifier.size(20.dp),
                tint = Color.White
            )


        }

    }
}


@Composable
fun DualHomeButton(
    state:HomeUiState,
    event:(HomeEvent)->Unit,

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
                .background(if (state.isWalletCLicked) colorResource(R.color.red) else Color.Transparent)
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
                .background(if (state.isHistoryCLicked) colorResource(R.color.red) else Color.Transparent)
                .clickable {
                    event(HomeEvent.onHistoryButtonClicked)
                },
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

}

@Composable
fun HomeCard(
    state: HomeUiState
) {
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(200.dp)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painterResource(R.drawable.rectangle_83),
                contentDescription = null,
                Modifier.fillMaxSize()

            )

            Column(
                Modifier.fillMaxSize().padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Box(
                    contentAlignment = Alignment.Center
                ){
                    Row(

                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,

                        ) {

                        Text(
                            stringResource(R.string.Walletbalance),
                            Modifier.padding(top = 8.dp),
                            fontSize = 13.33.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                            fontFamily = nunitosansFamily
                        )

                        Icon(
                            painter = painterResource(R.drawable.arrow_down),
                            contentDescription = null,
                            Modifier
                                .padding(top=8.dp)
                                .width(10.dp)
                                .height(20.dp),
                            tint = Color.White
                        )
                    }
                }


                Spacer(Modifier.height(20.dp))


               BalanceWithToggle(state)



                Spacer(Modifier.height(20.dp))
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icons(
                        painterResource(R.drawable.wallet),
                        text = stringResource((R.string.fund))
                    )

                    Icons(
                        painterResource(R.drawable.send_2),
                        text = stringResource((R.string.send))
                    )
                    Icons(
                        painterResource(R.drawable.more),
                        text = stringResource((R.string.more))
                    )
                }


            }
        }




}

@Composable
fun BalanceWithToggle(state: HomeUiState) {
    state.isBalanceVisible=false

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = if (state.isBalanceVisible) state.balance else "********",
            fontFamily = poppinsFontFamily,
            fontSize = 23.04.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )


        IconButton(onClick = { state.isBalanceVisible = !(state.isBalanceVisible) }) {
            Icon(
                painter = if (state.isBalanceVisible) painterResource( R.drawable.eye) else painterResource(R.drawable.eye_slash),
                contentDescription = if (state.isBalanceVisible) "Hide Balance" else "Show Balance",
                tint = Color.White
            )
        }
    }
}

@Composable
fun Icons(
    icon: Painter,
    text: String
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,

            ) {

            Image(
                painter = painterResource(
                    R.drawable.ellipse_1
                ),
                contentDescription = null,
                Modifier
                    .width(36.dp)
                    .height(36.dp),
                alignment = Alignment.Center
            )

            Image(
                painter = painterResource(R.drawable.ellipse_6),
                contentDescription = null,
                Modifier
                    .width(24.dp)
                    .height(24.dp),
                alignment = Alignment.Center,
            )

            Icon(
                painter = icon,
                contentDescription = null,
                tint = colorResource(R.color.red),

            )
            Spacer(Modifier.height(4.dp))
        }

        Text(
            text = text,
            fontFamily = nunitosansFamily,
            fontSize = 11.11.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )

    }


    Spacer(Modifier.width(30.dp))

}

@Composable
fun QuickSend() {

    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,

        ) {

        Text(
            text = (stringResource(R.string.quicksend)),
            color = colorResource(R.color.AppBlack),
            fontSize = 19.2.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = poppinsFontFamily
        )
    }

    Box(contentAlignment = Alignment.Center) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically

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
                    (painterResource(R.drawable.add)),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
            }


            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(0.5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val items = listOf(
                    QuickSendConstants(R.drawable.user_placeholder, name = "Ammaar"),
                    QuickSendConstants(R.drawable.user_placeholder, name = "Isaac"),
                    QuickSendConstants(R.drawable.user_placeholder, name = "Yassir"),
                    QuickSendConstants(R.drawable.user_placeholder, name = "Ismail")
                )

                items(items) { item ->
                    QuicksendTemplate(
                       profilePic =  item.image,
                        name = item.name
                    )
                }

            }

        }
    }


}

@Composable
fun QuicksendTemplate(
    modifier: Modifier = Modifier,
    profilePic: Int,
    name: String
) {

    Box(
        modifier
            .padding(4.dp)
            .border(
                1.dp,
                shape = RoundedCornerShape(95),
                color = Color.Black
            )
            .clip(RoundedCornerShape(95.dp)),
        contentAlignment = Alignment.Center,


        ) {
        Row(
            modifier
                .width(116.dp)
                .height(50.dp)
                .padding(horizontal = 4.dp)
                .clip(RoundedCornerShape(95.dp))
                .background(colorResource(R.color.background)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Image(
                painter = painterResource(profilePic),
                contentDescription = "User Profile",
                modifier
                    .size(40.dp)
                    .background(color = Color.Unspecified, shape = CircleShape)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = name,
                fontSize = 16.sp,
                color = colorResource(R.color.AppBlack),
                fontWeight = FontWeight.Normal,
                fontFamily = poppinsFontFamily,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )


        }
    }
}


@Composable
fun RecentTransactions(modifier: Modifier=Modifier,
                       event: (HomeEvent) -> Unit){
    Row(
        Modifier.fillMaxWidth(),
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
            modifier = Modifier
                .clickable { event(HomeEvent.onSeeMoreButtonCLicked) },
            color = colorResource(R.color.AppBlack),
            fontSize = 13.3.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = poppinsFontFamily
        )
    }
    Spacer(Modifier.height(3.dp))

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val items = listOf(
            TransactionsHistory(1,R.drawable.ellipse_9,"Jacob Jones","June 28.00:001am", "$-578"),
            TransactionsHistory(2,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$78"),
            TransactionsHistory(3,R.drawable.ellipse_9,"Jacob Jones","June 28.00:001am", "$-278"
            ),
            TransactionsHistory(4,R.drawable.ellipse_9__1_,"Jacob Jones","June 28.00:001am", "$1578")
        )

        items(items){item->
            TransactionTemplate(modifier,item.name,item.date,item.image,item.amount)

        }

        
        
        
    }


}

@Composable
fun TransactionTemplate(
    modifier: Modifier=Modifier,
    name: String,
    timeAndDate:String,
    profilePicture:Int,
    amount:String
){
    Row(
        modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(colorResource(R.color.background)),
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
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontFamily = poppinsFontFamily
            )

            Text(
                text = timeAndDate,
                fontSize = 13.33.sp,
                color = Color.Black,
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
fun BottomBar(
    modifier: Modifier=Modifier,
    state: HomeUiState,

    ){
    Card(
       modifier= Modifier.width(390.dp).height(80.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){



        }
    }
}


@Composable
@Preview
fun HomePreview(

) {
        val viewModel: MobileCahAppViewModel = hiltViewModel()
        val state = viewModel.home.collectAsState()
        val navController:NavController = rememberNavController()
        Home(state.value, event = viewModel::OnHomeEvent,navController)

    }



