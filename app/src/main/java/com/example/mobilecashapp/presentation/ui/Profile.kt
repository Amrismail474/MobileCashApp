package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.User
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun Profile(navController: NavController){
    Scaffold(topBar = {GeneralTopAppBar(stringResource(R.string.profile), navController)}) { paddingValues->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.background))
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Spacer(Modifier.height(36.dp))
            ProfileProfilePicture(user)
            ProfileCustomization()
        }
} }
//@Composable
//fun ProfileTopbar(
//    modifier: Modifier = Modifier
//){
//
//    Row(
//        modifier
//            .fillMaxWidth()
//            .padding(top=58.dp)
//            .background(colorResource(R.color.background)),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center
//    ) {
//
//        Box (
//            contentAlignment = Alignment.TopCenter
//        ){
//
//            Text(
//                stringResource(R.string.profile),
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 19.2.sp,
//                color = colorResource(R.color.AppBlack),
//                fontFamily = poppinsFontFamily,
//            )
//        }
//
//    }
//
//}

@Composable
fun ProfileProfilePicture(
    user: User
){
    
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

    }
    Box(
        contentAlignment = Alignment.Center
    ){
        Image(
            painterResource(R.drawable.ellipse_11),
            contentDescription = null,
            Modifier.width(106.dp)
                .height(106.dp)

        )

        Box(
            Modifier
                .size(94.dp)
                .border(
                    BorderStroke(2.dp, Color.White),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource( user.profilePicture),
                contentDescription = "Profile Picture",
                Modifier.width(94.dp)
                    .height(94.dp)

            )
        }



    }
    Spacer(Modifier.height(20.dp))

    Text(
        text =  user.firstName,
        color = colorResource(R.color.AppBlack),
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 19.2.sp,

    )

    Spacer(Modifier.height(8.dp))
    Text(
        text =  user.gmail,
        color = colorResource(R.color.AppBlack),
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 13.3.sp,
    )
}


@Composable
fun ProfileCustomization(){
    Column (
        Modifier.padding(top=16.dp),
        verticalArrangement =Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        ProfileTemplate(
            icon= painterResource(R.drawable.frame),
            title = stringResource(R.string.editProfile),
            subtitle = stringResource(R.string.editProfileInfo)
        )

        ProfileTemplate(
            icon= painterResource(R.drawable.setting),
            title = stringResource(R.string.setting),
            subtitle = stringResource(R.string.settingSubtitle)
        )
        ProfileTemplate(
            icon= painterResource(R.drawable.moon),
            title = stringResource(R.string.Darkmode),
            subtitle = stringResource(R.string.Darkmodesubtitle),
            isToggleButton = true
        )
        ProfileTemplate(
            icon= painterResource(R.drawable.headphones),
            title = stringResource(R.string.help),
            subtitle = stringResource(R.string.helpsubtitle)
        )
        ProfileTemplate(
            icon= painterResource(R.drawable.shield_tick),
            title = stringResource(R.string.termsandcondition),
            subtitle = stringResource(R.string.termsandconditionsubtitile)
        )
        ProfileTemplate(
            icon= painterResource(R.drawable.log_out),
            title = stringResource(R.string.signout),
            subtitle = stringResource(R.string.signoutsubtitle)
        )
    }
}



@Composable
fun ProfileTemplate(
    modifier: Modifier=Modifier,
    icon:Painter,
    isToggleButton:Boolean=false,
    title:String,
    subtitle:String
)

    {
        var isChecked by remember { mutableStateOf(false) }
        Row(
            modifier
                .fillMaxWidth()
                .padding(end=4.dp)
                .background(colorResource(R.color.background)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
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
                    icon,
                    contentDescription = null,
                    tint = Color.White
                )

            }
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontFamily = poppinsFontFamily
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    fontSize = 13.33.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    fontFamily = nunitosansFamily
                )


            }


            Spacer(Modifier.weight(1f))


                if(isToggleButton){
                    Switch(

                        checked = isChecked,
                        onCheckedChange = {isChecked = it},
                        Modifier.width(40.dp).height(40.dp)

                    )
                }else{
                    IconButton(onClick = {}) {
                        Icon(
                            painterResource(R.drawable.halfarrow_right),
                            contentDescription = null
                        )
                    }
                }


        }}





@Composable
@Preview
fun ProfilePreview(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.background))
            .padding(horizontal = 6.dp, vertical = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        val user = User("AL-HASSAN" ,"SOLATE",R.drawable.ellipse_9,
            "hassansolate202@gmail.com","08052377416","0431609284","18,952.7")

        Spacer(Modifier.height(36.dp))
        ProfileProfilePicture(user)
        ProfileCustomization()
    }

}