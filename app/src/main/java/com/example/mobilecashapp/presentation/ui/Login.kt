package com.example.mobilecashapp.presentation.ui

import android.util.Log
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.Graph
import com.example.mobilecashapp.presentation.events.LoginEvent
import com.example.mobilecashapp.presentation.state.LoginUiState
import com.example.mobilecashapp.presentation.viewmodel.MobileCahAppViewModel
import com.example.mobilecashapp.presentation.constants.Screen
import com.example.mobilecashapp.ui.theme.MobileCashAppTheme
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun Login(
    state: LoginUiState,
    event: (LoginEvent) -> Unit,
    navController: NavController
) {


    LaunchedEffect(state.signUpSwitch){
        if(state.signUpSwitch){
            navController.navigate(Screen.SignUp.route){
                popUpTo(Screen.SignUp.route){
                    inclusive=false
                }
            }
        }
    }

    LaunchedEffect(state.onForgetPasswordClicked){
        if(state.onForgetPasswordClicked){
            navController.navigate(Screen.ForgetPassword.route){
                popUpTo(Screen.Login.route){
                    inclusive = true
                }
            }
        }
    }

    LaunchedEffect(state.onSignUpOnLoginClicked){
        if(state.onSignUpOnLoginClicked){
            navController.navigate(Screen.SignUp.route){
                popUpTo(Screen.Login.route){
                    inclusive = true
                }
            }
        }
    }

    LaunchedEffect(state.isLoggedInSuccessful){
        if(state.isLoggedInSuccessful){
                navController.navigate(Graph.Home.title){
                popUpTo(Screen.OnBoarding3.route){
                    inclusive = false
                }
        }
    }}

    if(state.showSuccessDialog){
        SuccessDialog(stringResource(R.string.successText),navController)
    }

    if(state.showFailureDialog){
        ErrorDialog(stringResource(R.string.errorText),
            stringResource(R.string.okay),
            onOkayButtonCLicked = {
                navController.navigate(Screen.Login.route)

            }
        )
    }



    Scaffold { paddingValues->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.background))
            .padding(paddingValues)
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CommonHeader(
            text1 = stringResource(R.string.LoginText),
            text2 =  stringResource(R.string.Loginsubtitle),
            isextrawords = true
        )

        Spacer(Modifier.height(32.dp))
        DualButton(state,event)

        Spacer(Modifier.height(24.dp))

        LoginPhoneandPassword(state, event = event)


    }

}
}


@Composable
fun DualButton(
    state: LoginUiState,
    event:(LoginEvent)->Unit,
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

        val baseModifiers = Modifier
            .width(60.dp)
            .height(24.dp)
            .clip(RoundedCornerShape(15.dp))


        Box(
            modifier = baseModifiers
                .background(if (state.loginSwitch) colorResource(R.color.red) else Color.Transparent)
                .clickable { event(LoginEvent.OnLoginButtonClicked)},
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.Login),
                fontWeight = FontWeight.Normal,
                fontSize = 11.11.sp,
                color = Color.White,
                fontFamily = nunitosansFamily,
                modifier = Modifier.padding(0.dp)
            )
        }

        Spacer(Modifier.width(5.dp))

        Box(
            modifier = baseModifiers
                .background(if (state.signUpSwitch) colorResource(R.color.red) else Color.Transparent)
                .clickable {event(LoginEvent.OnSignUpButtonClicked) },
            contentAlignment = Alignment.Center
        ) {
            Text(
                stringResource(R.string.signup),
                fontWeight = FontWeight.Normal,
                fontSize = 11.11.sp,
                color = Color.White,
                fontFamily = nunitosansFamily,

                )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPhoneandPassword(
    state: LoginUiState,
    event: (LoginEvent) -> Unit,
) {
    OutlinedTextField(
        value = state.phoneNumber,
        onValueChange = {
            event(LoginEvent.OnPhoneChanged(it))
        },
        Modifier
            .width(350.dp)
            .height(52.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray
        ),
        label = { Text(stringResource(R.string.enter_phone)) },
        shape = RoundedCornerShape(60.dp),
        leadingIcon = {
            Icon(
                painterResource(R.drawable.phone),
                contentDescription = "Phone",
                tint = colorResource(R.color.red)
            )
        },)

    Spacer(Modifier.height(8.dp))

    OutlinedTextField(
        value = state.password,
        onValueChange = {
            event(LoginEvent.OnPasswordChanged(it))
        },
        Modifier
            .width(350.dp)
            .height(52.dp),
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
            val icon=  if (state.passwordVisible){
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
        visualTransformation = if (state.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

        )



    Row(
        Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        Checkbox(
            checked = state.onRememberPasswordchecked,
            onCheckedChange = { event(LoginEvent.OnRememberPassword(state.onRememberPasswordchecked)) },
            Modifier
                .width(14.dp)
                .height(14.dp)
                .padding(top = 12.dp,end=6.dp),
            colors = CheckboxDefaults.colors(
                checkedColor = colorResource(R.color.red)
            )
        )
        Spacer(Modifier.width(8.dp))

        Text(
            stringResource(R.string.remember_password),
            Modifier.padding(top = 2.dp,end=6.dp),
            color= colorResource(R.color.AppBlack),
            fontSize = 11.11.sp,
            fontFamily = nunitosansFamily,
            fontWeight = FontWeight.SemiBold

        )

        Spacer(Modifier.weight(1f))

        Text(
            stringResource(R.string.forget_password),
            Modifier.clickable {
                event(LoginEvent.OnForgetPasswordCLicked)
            },
            fontSize = 13.33.sp,
            fontFamily = nunitosansFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.red)

        )
    }

    Spacer(Modifier.height(20.dp))


    LoginSignUpText(event)

    Spacer(Modifier.height(20.dp))
    Button(
        onClick = {
            Log.d("clickedr", "clicked")
            event(LoginEvent.Login) },
        modifier = Modifier
            .width(350.dp)
            .height(52.dp)
            .border(
                width = 5.dp,
                color = colorResource(R.color.red).copy(alpha = 0.3f),
                shape = RoundedCornerShape(60.dp)
            ).padding(4.dp),
        enabled = state.phoneNumber.isNotEmpty() && state.password.isNotEmpty(),
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
                    if (state.phoneNumber.isEmpty() && state.password.isEmpty()) {
                        Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.red).copy(alpha = 0.5f),
                                colorResource(R.color.red).copy(alpha = 0.5f)
                            )
                        )
                    } else {
                        SolidColor(colorResource(R.color.red))
                    },
                    shape = RoundedCornerShape(60.dp)
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
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

    Spacer(Modifier.height(16.dp))

    LoginTermsAndCondition(event)


}

@Composable
fun LoginSignUpText(
    event: (LoginEvent) -> Unit
) {
    val fullText = stringResource(R.string.noaccount)
    val clickable = stringResource(R.string.clickhere)


    val annotatedString = buildAnnotatedString {
        append(fullText.substringBefore(clickable))
        append("  ")
        pushStringAnnotation(
            tag = "Sign Up",
            annotation = "sign_up"
        )
        withStyle(
            style = SpanStyle(
                color = colorResource(R.color.red),
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(clickable)
        }
        pop()
    }

    Text(
        text = annotatedString,
        Modifier.clickable { event(LoginEvent.SignUp) },
        Color.Black,
        fontSize = 13.33.sp,
        fontFamily = nunitosansFamily,
        fontWeight = FontWeight.Normal)
}


@Composable
fun LoginTermsAndCondition(
    event: (LoginEvent) -> Unit
) {
    val fullText = stringResource(R.string.terms)
    val clickable = stringResource(R.string.condition)


    val annotatedString = buildAnnotatedString {
        append(fullText.substringBefore(clickable))
        append("  ")
        pushStringAnnotation(
            tag = "TermsAndCondition",
            annotation = "Terms ANd Condition "
        )
        withStyle(
            style = SpanStyle(
                color = colorResource(R.color.red),
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(clickable)
        }
        pop()
    }
    Text(
        text = annotatedString,
        Modifier.clickable { event(LoginEvent.Terms) },
        Color.Black,
        fontSize = 13.33.sp,
        fontFamily = nunitosansFamily,
        fontWeight = FontWeight.Normal)
}






@Preview
@Composable
fun PreviewCreateAccount() {
    MobileCashAppTheme {

        val viewmodel: MobileCahAppViewModel = hiltViewModel()
        val state = viewmodel.loginUiState.collectAsState()
        val navController: NavController = rememberNavController()
        Login(state.value, viewmodel::OnLoginEvent,navController)

    }
}