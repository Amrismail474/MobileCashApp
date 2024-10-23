package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.Transaction
import com.example.mobilecashapp.ui.theme.nunitosansFamily


@Composable
fun Notification(modifier: Modifier = Modifier,navController: NavController) {
    Scaffold(
        topBar = { GeneralTopAppBar(stringResource(R.string.notification),navController) }
    ) {  paddingValues ->
        Column(
            modifier
                .fillMaxSize()
                .background(colorResource(R.color.background)).padding(paddingValues)
                .padding(8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NotificationCard()
        }

    }}


@Composable
fun NotificationCard(
    modifier: Modifier = Modifier
) {

    val transaction = Transaction("kaylin", "5000", "8-2-24", "000085752257", "card")




    Card(
        modifier
            .width(330.dp)
            .height(238.dp)
            .background(colorResource(R.color.background))
            .padding(8.dp),
        shape = RoundedCornerShape(15.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .offset(y = 60.dp)
        ) {

            Text(
                stringResource(R.string.creditmessage, transaction.amount, transaction.sender),
                Modifier.padding(8.dp),
                fontSize = 13.33.sp,
                fontFamily = nunitosansFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.AppBlack),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(8.dp))

            Text(
                transaction.date,
                Modifier.padding(8.dp),
                fontSize = 13.33.sp,
                fontFamily = nunitosansFamily,
                fontWeight = FontWeight.Light,
                color = colorResource(R.color.AppBlack),
                textAlign = TextAlign.Center
            )


        }


    }


}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun NotificationTopAppBarSection(
//    modifier: Modifier = Modifier
//) {
//
//    TopAppBar(
//        title = {
//            Text(
//                stringResource(R.string.notification),
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 19.2.sp,
//                color = colorResource(R.color.Loginblack),
//                fontFamily = poppinsFontFamily,
//            )
//        },
//        navigationIcon = {
//            Box(
//                modifier = Modifier
//                    .size(72.dp)
//                    .padding(8.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Image(
//                    painter = painterResource(R.drawable.ellipse_7__2_),
//                    contentDescription = null,
//                    Modifier
//                        .width(52.dp)
//                        .height(52.dp),
//                )
//
//                Image(
//                    painter = painterResource(R.drawable.ellipse_8),
//                    contentDescription = null,
//                    Modifier
//                        .width(40.dp)
//                        .height(40.dp),
//                    contentScale = ContentScale.Crop
//                )
//                Icon(
//                    (painterResource(R.drawable.arrow_right)),
//                    contentDescription = null,
//                    Modifier.size(20.dp),
//                    tint = Color.White
//                )
//
//
//            }
//        },
//        colors = TopAppBarDefaults.mediumTopAppBarColors(
//            containerColor = colorResource(R.color.background)
//        )
//    )
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
//        Box(
//            contentAlignment = Alignment.TopCenter
//        ) {
//
//            Text(
//                stringResource(R.string.notification),
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 19.2.sp,
//                color = colorResource(R.color.Loginblack),
//                fontFamily = poppinsFontFamily,
//            )
//        }
//
//
//        Box(
//            modifier = Modifier.size(12.dp)
//        ) {}
//
//    }
//}



@Composable
@Preview
fun NotificationPreview() {
    val navController:NavController= rememberNavController()
    Notification(navController = navController)
}