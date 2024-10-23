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
import androidx.compose.ui.text.TextStyle
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
import com.example.mobilecashapp.presentation.constants.Screen
import com.example.mobilecashapp.presentation.viewmodel.SignUpViewModel
import com.example.mobilecashapp.presentation.events.SignUpEvent
import com.example.mobilecashapp.presentation.state.SignUpUiState
import com.example.mobilecashapp.ui.theme.MobileCashAppTheme
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun SignUp(
    state: SignUpUiState,
    event: (SignUpEvent) -> Unit,
    navController: NavController
) {


    LaunchedEffect(state.isSignUpSuccessful) {
        Log.d("I'm here", state.isSignUpSuccessful.toString())
        if(state.isSignUpSuccessful){

            navController.navigate(Screen.HomeScreen.route){
                Log.d("I'm here", "Navigated")
//                popUpTo(Screen.SignUp.route){
//                    inclusive=true
//                }
            }
        }
    }


    LaunchedEffect(state.isLoginOnSignupClicked){
        if (state.isLoginOnSignupClicked){
            navController.navigate(Screen.Login.route){
                popUpTo(Screen.SignUp.route){
                    inclusive=true
                }
            }

        }
    }

    LaunchedEffect(state.onTermAndConditionCLicked){
        if (state.onTermAndConditionCLicked){
            navController.navigate(Screen.Terms.route){
                popUpTo(Screen.SignUp.route){
                    inclusive=true
                }
            }
        }
    }

    LaunchedEffect(state.loginSwitch){
        if(state.loginSwitch){
            navController.navigate(Screen.Login.route)
        }
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
                text2 =  stringResource(R.string.SignUpSubtitle),
                isextrawords = true)

            Spacer(Modifier.height(32.dp))

            DualSIgnUpButton(state=state,event = event)

            Spacer(Modifier.height(24.dp))

            SignUpemailandpassword(state = state, event = event)
        }

        }
    }


@Composable
fun DualSIgnUpButton(
    state: SignUpUiState,
    event:(SignUpEvent)->Unit,
) {

    Row(
        Modifier
            .width(138.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(30.dp))
//
//            .border(
//                width = 2.dp,
//                color = colorResource(R.color.red).copy(alpha = 0.3f),
//                shape = RoundedCornerShape(30.dp)
//            )

            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(R.color.red).copy(alpha = 0.2f),
                        colorResource(R.color.red).copy(alpha = 0.2f)
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
                .background(if (state.loginSwitch) colorResource(R.color.red) else Color.Transparent)
                .clickable {
                    event(SignUpEvent.OnLoginSwitchButtonClicked)
                }, contentAlignment = Alignment.Center
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
            modifier = BaseModifiers
                .background(if (state.signUpSwitch) colorResource(R.color.red) else Color.Transparent)
                .clickable {
                    event(SignUpEvent.OnSignUpSwitchButtonClicked)
                }, contentAlignment = Alignment.Center
        ) {
            Text(
                stringResource(R.string.signup),
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontSize = 11.11.sp,
                fontFamily = nunitosansFamily,

                )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpemailandpassword(
    state: SignUpUiState,
    event: (SignUpEvent) -> Unit,
) {


    OutlinedTextField(
        value = state.name,
        onValueChange = {
            event(SignUpEvent.OnNameChanged(it))
        },
        Modifier
            .width(350.dp)
            .height(52.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray
        ),
        label = { Text(stringResource(R.string.your_name)) },
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 18.sp
        ),
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


    OutlinedTextField(value = state.phoneNumber,
        onValueChange = {
            event(SignUpEvent.OnPhoneChanged(it))
        },
        Modifier
            .width(350.dp)
            .height(52.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray
        ),
        label = { Text(stringResource(R.string.enter_yourPhoneNumber)) },
        shape = RoundedCornerShape(60.dp),
        leadingIcon = {
            Icon(
                painterResource(R.drawable.phone),
                contentDescription = "Password",
                tint = colorResource(R.color.red)
            )
        })


    Spacer(Modifier.height(16.dp))


    OutlinedTextField(value = state.password,
        onValueChange = { event(SignUpEvent.OnPasswordChanged(it)) },
        Modifier
            .width(350.dp)
            .height(52.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray
        ),
        label = { Text(stringResource(R.string.enter_yourPassword)) },
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
                onClick ={ event(SignUpEvent.TogglePasswordVisibility)}
            ) {
                Icon(
                    icon,
                    contentDescription = "Show Password"
                )
            }
        },
        visualTransformation = if (state.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

        )


    Spacer(Modifier.height(16.dp))


    OutlinedTextField(value = state.confirmPassword,
        onValueChange = { event(SignUpEvent.OnConfirmPassword(it)) },
        Modifier
            .width(350.dp)
            .height(52.dp) ,
        colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
        focusedBorderColor = Color.Gray,
        unfocusedBorderColor = Color.LightGray
    ),
        label = { Text(stringResource(R.string.confirm_yourPassword)) },
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
                onClick ={ event(SignUpEvent.TogglePasswordVisibility)}
            ) {
                Icon(
                    icon,
                    contentDescription = "Show Password"
                )
            }
        },
        visualTransformation = if (state.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
    )

    Spacer(Modifier.height(20.dp))

    LoginLink { event(SignUpEvent.Login) }

    CheckTermsAndCondition(state = state, event = event )

    Spacer(Modifier.height(20.dp))
    

    Spacer(Modifier.height(20.dp))



    Button(
        onClick = { event(SignUpEvent.SignUp) },
        modifier = Modifier
            .width(350.dp)
            .height(52.dp)
            .border(
                width = 5.dp,
                color = colorResource(R.color.red).copy(alpha = 0.3f),
                shape = RoundedCornerShape(60.dp))
            .padding(4.dp),
        enabled = state.phoneNumber.isNotEmpty() && state.name.isNotEmpty()&& state.confirmPassword.isNotEmpty(),
        shape = RoundedCornerShape(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent, contentColor = Color.White
        ),
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .background(
                    if (state.phoneNumber.isEmpty() && state.name.isEmpty() && state.confirmPassword.isEmpty()) {
                        Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.red).copy(alpha = 0.5f),
                                colorResource(R.color.red).copy(alpha = 0.5f)
                            )
                        )
                    } else {
                        SolidColor(colorResource(R.color.red))
                    }, shape = RoundedCornerShape(60.dp)
                )
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.signup),
                color = Color.White,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

    Spacer(Modifier.height(16.dp))

    SignUpTermsAndCondition (event)


}

@Composable
fun LoginLink(
    event: (SignUpEvent) -> Unit
) {
    val fullText = stringResource(R.string.alreadyRegistered)
    val clickable = stringResource(R.string.clickheretoLogin)


    val annotatedString = buildAnnotatedString {
        append(fullText.substringBefore(clickable))
        append("  ")
        pushStringAnnotation(
            tag = "Login", annotation = "login"
        )
        withStyle(
            style = SpanStyle(
                color = colorResource(R.color.red), textDecoration = TextDecoration.Underline
            )
        ) {
            append(clickable)
        }
        pop()
    }
    Text(
        text = annotatedString,
        Modifier.clickable { event(SignUpEvent.Login)},
        Color.Black,
        fontSize = 13.33.sp,
        fontFamily = nunitosansFamily,
        fontWeight = FontWeight.Normal)

}


@Composable
fun CheckTermsAndCondition(
    state: SignUpUiState,
    event: (SignUpEvent) -> Unit
) {
    val beforeText = stringResource(R.string.signupTerms)
    val clickable = stringResource(R.string.signupTermsLinkText)
    val afterText = stringResource(R.string.signupCOndition)


    val annotatedString = buildAnnotatedString {
        append(beforeText.substringBefore(clickable))
        append("  ")

        pushStringAnnotation(
            tag = "SignUpTermsAndCondition", annotation = "SignUp Terms And Condition "
        )
        withStyle(
            style = SpanStyle(
                color = colorResource(R.color.red),
            )
        ) {
            append(clickable)
            }

        pop()

        append(" ")
        append(afterText)
    }

    Row(
        Modifier.padding(16.dp), horizontalArrangement = Arrangement.Center
    ) {

        Checkbox(
            checked = state.signUpChecked,
            onCheckedChange = { event(SignUpEvent.OnTermsAcceptedMarked(it)) },
            Modifier
                .width(14.dp)
                .height(14.dp)
                .padding(top = 12.dp,end=6.dp),
            colors = CheckboxDefaults.colors(
                checkedColor = colorResource(R.color.red)
            )
        )

        Spacer(Modifier.width(8.dp))

        Text(annotatedString,Modifier.clickable {
            event(SignUpEvent.OnTermsAndConditionCLicked)

        },
            Color.Black,
            fontSize = 11.11.sp,
            fontFamily = nunitosansFamily,
            fontWeight = FontWeight.Normal
        )

    }


}

@Composable
fun SignUpTermsAndCondition (
    event: (SignUpEvent) -> Unit
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
        Modifier.clickable { event(SignUpEvent.OnTermsAndConditionCLicked) },
        Color.Black,
        fontSize = 13.33.sp,
        fontFamily = nunitosansFamily,
        fontWeight = FontWeight.Normal)
}


@Preview
@Composable
fun PreviewSignupAccount() {
    MobileCashAppTheme {

        val viewmodel: SignUpViewModel = hiltViewModel()
        val state = viewmodel.signUpUiState.collectAsState()
        val navController:NavController= rememberNavController()
        SignUp(state.value, viewmodel::signUpEvent,navController)

    }
}