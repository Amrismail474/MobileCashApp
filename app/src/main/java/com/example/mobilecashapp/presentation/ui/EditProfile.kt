package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.User
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun EditProfileTopbar(
    modifier: Modifier = Modifier
){

    Row(
        modifier
            .fillMaxWidth()
            .padding(top=8.dp)
            .background(colorResource(R.color.background)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Box (
            contentAlignment = Alignment.TopCenter
        ){

            Text(
                stringResource(R.string.profile),
                fontWeight = FontWeight.SemiBold,
                fontSize = 19.2.sp,
                color = colorResource(R.color.AppBlack),
                fontFamily = poppinsFontFamily,
            )
        }

    }

}

@Composable
fun EditProfileProfilePicture(
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
fun ProfileDetail(
    user: User
) {


    OutlinedTextField(
        value = user.firstName,
        onValueChange = {

        },
        Modifier
            .width(350.dp)
            .height(52.dp).clip(RoundedCornerShape(60.dp)).background(Color.White),
        shape = RoundedCornerShape(60.dp),
        leadingIcon = {
            Icon(
                painterResource(R.drawable.user),
                contentDescription = "Phone",
                tint = colorResource(R.color.red)
            )
        },
    )

    Spacer(Modifier.height(16.dp))


    OutlinedTextField(value = user.lastName,
        onValueChange = {

        },
        Modifier
            .width(350.dp)
            .height(52.dp).clip(RoundedCornerShape(60.dp)).background(Color.White),
        shape = RoundedCornerShape(60.dp),
        leadingIcon = {
            Icon(
                painterResource(R.drawable.user),
                contentDescription = "Phone",
                tint = colorResource(R.color.red)
            )
        })


    Spacer(Modifier.height(16.dp))

    OutlinedTextField(
        value = user.gmail,
        onValueChange = {

        },
        Modifier
            .width(350.dp)
            .height(52.dp).clip(RoundedCornerShape(60.dp)).background(Color.White),
        shape = RoundedCornerShape(60.dp),
        leadingIcon = {
            Icon(
                painterResource(R.drawable.sms),
                contentDescription = "Email",
                tint = colorResource(R.color.red)
            )
        },
    )

    Spacer(Modifier.height(16.dp))


    OutlinedTextField(value = user.phone,
        onValueChange = {

        },
        Modifier
            .width(350.dp)
            .height(52.dp).clip(RoundedCornerShape(60.dp)).background(Color.White),
        shape = RoundedCornerShape(60.dp),
        leadingIcon = {
            Icon(
                painterResource(R.drawable.phone),
                contentDescription = "Phone",
                tint = colorResource(R.color.red)
            )
        })

    Spacer(Modifier.height(20.dp))


    Spacer(Modifier.height(60.dp))

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
                text = stringResource(R.string.update),
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
fun EditProfilePreview(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.background))
            .padding(horizontal = 6.dp, vertical = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        val user = User("AL-HASSAN ","SOLATE",
            R.drawable.ellipse_9,"hassansolate202@gmail.com","08052377416","0431609284","18,952.7")
        EditProfileTopbar()
        Spacer(Modifier.height(36.dp))
        EditProfileProfilePicture(user)
        Spacer(Modifier.height(56.dp))
        ProfileDetail(user)

    }

}