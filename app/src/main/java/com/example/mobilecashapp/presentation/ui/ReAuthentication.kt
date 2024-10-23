package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.viewmodel.ReAuthenticationViewModel
import com.example.mobilecashapp.presentation.constants.Screen
import com.example.mobilecashapp.presentation.constants.User
import com.example.mobilecashapp.presentation.events.ReAuthenticationEvent
import com.example.mobilecashapp.presentation.state.ReAuthenticationState
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily


@Composable
fun ReAuthentication(
    state:ReAuthenticationState,
    event: (ReAuthenticationEvent)->Unit,
    navController: NavController
){

    LaunchedEffect (state.isForgetPasswordClicked){
        navController.navigate(Screen.ForgetPassword.route){
//            popUpTo(Screen.SignUp.route){
//                inclusive=true
//            }
        }
    }

    LaunchedEffect (state.isSwitchAccountClicked){
        navController.navigate(Screen.Login.route){
            popUpTo(Screen.SignUp.route){
                inclusive=false
            }
        }
    }

//    LaunchedEffect (state.isLoginButtonPressed){
//        navController.navigate(Graph.Home.title){
//            popUpTo(Screen.Login.route){
//                inclusive=false
//        }
//    }}

    if(state.isSuccessDialog){
        SuccessDialog(stringResource(R.string.successText),navController)
    }

    if(state.isErrorDialog){
        ErrorDialog(stringResource(R.string.errorText2),
            stringResource(R.string.okay),
            onOkayButtonCLicked = {
                navController.navigate(Screen.Login.route)
            })
    }




    Scaffold() { paddingValues->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.background))
                .padding(horizontal = 6.dp, vertical = 2.dp).padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Spacer(Modifier.height(50.dp))
            CommonHeader(
                text1 = stringResource(R.string.ForgetpasswordText),
                text2 =  stringResource(R.string.Forgetpasswordsubtitle)
            )

            Spacer(Modifier.height(50.dp))
            ReauthenticationSection1(state.user)
            Spacer(Modifier.height(30.dp))
            ReauthenticationOutlinedbox(state,event)
            ReAuthenticationComponent3(event)

        }

    }
}



@Composable
fun ReauthenticationSection1(
    user: User
){
    val masked= maskPhoneNumber(user.phone)

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
        text =  "${user.firstName}(${masked})",
        color = colorResource(R.color.AppBlack),
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.2.sp,

        )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReauthenticationOutlinedbox(
    state:ReAuthenticationState,
    event: (ReAuthenticationEvent) -> Unit
){
    Row(
        Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = state.password,
            onValueChange = {

            },
            Modifier
                .width(288.dp)
                .height(62.dp).padding(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.LightGray
            ),
            label = { Text(stringResource(R.string.enter_password)) },
            shape = RoundedCornerShape(60.dp),
            leadingIcon = {
                Icon(
                    painterResource(R.drawable.key),
                    contentDescription = "Password",
                    tint = colorResource(R.color.red)
                )
            },
            trailingIcon = {
                val icon=  if (state.isPasswordVisible){
                    painterResource(R.drawable.eye)
                }
                else{
                    painterResource(R.drawable.eye_slash)
                }
                IconButton(
                    onClick ={}
                ) {
                    Icon(
                        icon,
                        contentDescription = "Show Password"
                    )
                }
            },
            visualTransformation = if (state.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),

            )

        Box(
            modifier = Modifier
                .size(62.dp).padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ellipse_8),
                contentDescription = null,
                Modifier
                    .width(44.dp)
                    .height(44.dp),
                contentScale = ContentScale.Crop
            )
            Icon(
                (painterResource(R.drawable.group_71)),
                contentDescription = null,
                Modifier.size(24.dp),
                tint = Color.White
            )


        }
    }
    Box (contentAlignment = Alignment.Center){
        Row(
            Modifier.padding(12.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                stringResource(R.string.forget_password),
                Modifier.clickable {
                    event(ReAuthenticationEvent.onForgetPasswordClicked) },
                fontSize = 13.33.sp,
                fontFamily = nunitosansFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.red))
        }
    }
}

@Composable
fun ReAuthenticationComponent3(
    event: (ReAuthenticationEvent) -> Unit
){
    Column (
        Modifier.offset(y=150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){
        Box (Modifier.clickable { event(ReAuthenticationEvent.OnSwitchAccountClicked) },
            contentAlignment = Alignment.Center){
            Text(
                stringResource(R.string.switchAccount),
                fontSize = 13.33.sp,
                fontFamily = nunitosansFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.red)

            )
        }

        Spacer(Modifier.height(26.dp))


        Button(
            onClick = {
                event(ReAuthenticationEvent.OnLoginButtonClicked)
            },
            modifier = Modifier
                .width(350.dp)
                .height(52.dp)
                .border(
                    width = 5.dp,
                    color = colorResource(R.color.red).copy(alpha = 0.3f),
                    shape = RoundedCornerShape(60.dp)
                ) .padding(4.dp),

            shape = RoundedCornerShape(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        SolidColor(colorResource(R.color.red)),
                        shape = RoundedCornerShape(60.dp)
                    ).clip(RoundedCornerShape(60.dp))
                    .fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.login),
                    color = Color.White,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

fun maskPhoneNumber(phoneNumber: String): String {

    if (phoneNumber.length < 10) return phoneNumber

    val firstPart = phoneNumber.take(5)
    val lastPart = phoneNumber.takeLast(2)

    val maskedPart = "*".repeat(phoneNumber.length - 7)

    return "$firstPart$maskedPart$lastPart"
}

@Preview
@Composable
fun ReAuthenticationPreview(){
    val viewmodel: ReAuthenticationViewModel = hiltViewModel()
    val state = viewmodel.reAuthenticationUiState.collectAsState()
    val navController :NavController = rememberNavController()
    ReAuthentication(state.value,viewmodel::reAuthenticationEvent,navController)
}
