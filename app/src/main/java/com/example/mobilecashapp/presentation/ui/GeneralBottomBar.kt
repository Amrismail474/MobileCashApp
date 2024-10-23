//package com.example.mobilecashapp.presentation.ui
//
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import com.example.mobilecashapp.R
//import com.example.mobilecashapp.presentation.state.BottomNavigationItem
//
//@Composable
//fun BottomBar(
//    selelctedItemIndex:Int){
//    val items = listOf(
//        BottomNavigationItem("Home", R.drawable.home_clear),
//        BottomNavigationItem("Wallet", R.drawable.transaction_wallet),
//        BottomNavigationItem("Transaction", R.drawable.transaction_icon),
//        BottomNavigationItem("Profile", R.drawable.profileicon),
//    )
//
//
//    NavigationBar(
//        containerColor = Color.White
//    ) {
//        items.forEachIndexed { index, item ->
//            NavigationBarItem(
//                selected = selelctedItemIndex==index,
//                onClick = {selelctedItemIndex = index},
//                icon = {
//                    Icon(
//                    painterResource( item.Icon),
//                    contentDescription = "BottomBar Icons",
//                    tint = if(selelctedItemIndex==index) Color.Red else Color.Unspecified
//                )
//                },
//                label = { Text(item.tittle) },
//
//                )
//
//        }
//    }
//}