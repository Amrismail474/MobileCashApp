package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily



@Composable
fun AccountSecurity(
    navController: NavController
){
    Scaffold(
        topBar = { GeneralTopAppBar(stringResource(R.string.accountsecurity),navController) },
    ) {innerPadding->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .width(390.dp)
                .height(844.dp)
                .background(color = colorResource(R.color.background))
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            AccountSecurityFullList()
        }
    }
}


@Composable
fun AccountSecurityFullList(){
    Column (
        Modifier.padding(top=16.dp),
        verticalArrangement =Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,

        ){

        AccountSettingTemplate(
            icon=painterResource(R.drawable.security_user),
            title = stringResource(R.string.reset_password),
            subtitle = stringResource(R.string.reset_password_subtitle)
        )
        AccountSettingTemplate(
            icon=painterResource(R.drawable.arrow_swap),
            title = stringResource(R.string.biometrics),
            subtitle = stringResource(R.string.biometrics_subtitle),
            isToggleButton = true
        )
        AccountSettingTemplate(
            icon=painterResource(R.drawable.delete),
            title = stringResource(R.string.auto_login),
            subtitle = stringResource(R.string.auto_login_subtitle),
            isToggleButton = true
        )
    }
}



@Composable
fun AccountSettingTemplate(
    modifier: Modifier = Modifier,
    icon: Painter,
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
                Modifier.width(40.dp).height(40.dp),

                )
        }else{
            IconButton(onClick = {}) {
                Icon(
                    painterResource(R.drawable.halfarrow_right),
                    contentDescription = null
                )
            }
        }


    }
}


@Composable
@Preview
fun AccountSecurityPreview(){
    val navController:NavController= rememberNavController()
    AccountSecurity(navController)
}