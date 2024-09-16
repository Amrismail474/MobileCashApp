package com.example.mobilecashapp.presentation

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.MobileCashAppTheme
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun SignUp(
    state: SignUpUiState, event: (SignUpEvent) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CommonHeader(
            text1 = stringResource(R.string.LoginText),
            text2 =  stringResource(R.string.SignUpSubtitle)
        )
        Spacer(Modifier.height(32.dp))
        DualSIgnUpButton()

        Spacer(Modifier.height(24.dp))

        SignUpemailandpassword(
            state = state, onValueChange = event
        )
    }

}

@Composable
fun DualSIgnUpButton(
) {

    Row(
        Modifier
            .width(138.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(30.dp))

            .border(
                width = 2.dp,
                color = colorResource(R.color.red).copy(alpha = 0.3f),
                shape = RoundedCornerShape(30.dp)
            )

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

        Constants.loginSwitch = false
        Constants.signUpSwitch=true


        Box(
            modifier = BaseModifiers
                .background(if (Constants.loginSwitch) colorResource(R.color.red) else Color.Transparent)
                .clickable { }, contentAlignment = Alignment.Center
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



        Box(
            modifier = BaseModifiers
                .background(if (Constants.signUpSwitch) colorResource(R.color.red) else Color.Transparent)
                .clickable { }, contentAlignment = Alignment.Center
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

@Composable
fun SignUpemailandpassword(
    state: SignUpUiState,
    onValueChange: (SignUpEvent) -> Unit,
) {


    OutlinedTextField(
        value = state.Name,
        onValueChange = {
            onValueChange(SignUpEvent.OnNameChanged(it))
        },
        Modifier
            .width(350.dp)
            .height(52.dp),
        label = { Text(stringResource(R.string.your_name)) },
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
            onValueChange(SignUpEvent.OnPhoneChanged(it))
        },
        Modifier
            .width(350.dp)
            .height(52.dp),
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
        onValueChange = { onValueChange(SignUpEvent.OnPasswordChanged(it)) },
        Modifier
            .width(350.dp)
            .height(52.dp),
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
               painterResource(R.drawable.showandhide)
           }
           else{
                painterResource(R.drawable.baseline_remove_red_eye_24)
           }
            IconButton(
                onClick ={ onValueChange(SignUpEvent.TogglePasswordVisibility)}
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
        onValueChange = { onValueChange(SignUpEvent.OnConfirmPassword(it)) },
        Modifier
            .width(350.dp)
            .height(52.dp),
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
                painterResource(R.drawable.showandhide)
            }
            else{
                painterResource(R.drawable.baseline_remove_red_eye_24)
            }
            IconButton(
                onClick ={ onValueChange(SignUpEvent.TogglePasswordVisibility)}
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

    LoginLink { onValueChange(SignUpEvent.login) }

    CheckTermsAndcondition(state = state,
        toLoginPage = { onValueChange(SignUpEvent.login) },
        onValueChange = { onValueChange(SignUpEvent.OnTermsAcceptedChanged(state.SignUpchecked)) })

    Spacer(Modifier.height(20.dp))
    

    Spacer(Modifier.height(20.dp))

    Button(
        onClick = { onValueChange(SignUpEvent.login) },
        modifier = Modifier
            .width(350.dp)
            .height(52.dp)
            .border(
                width = 5.dp,
                color = colorResource(R.color.red).copy(alpha = 0.3f),
                shape = RoundedCornerShape(60.dp)
            ),
        enabled = state.phoneNumber.isNotEmpty() && state.password.isNotEmpty() && state.confirmPassword.isNotEmpty(),
        shape = RoundedCornerShape(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent, contentColor = Color.White
        ),
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .background(
                    if (state.phoneNumber.isEmpty() && state.password.isEmpty()) {
                        Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.red).copy(alpha = 0.4f),
                                colorResource(R.color.red).copy(alpha = 0.1f)
                            )
                        )
                    } else {
                        SolidColor(colorResource(R.color.red))
                    }, shape = RoundedCornerShape(60.dp)
                )
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

    Spacer(Modifier.height(16.dp))

    TermsAndcondition { LoginEvent.terms }


}

@Composable
fun LoginLink(
    login: () -> Unit
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
    ClickableText(text = annotatedString,

        style = TextStyle(
            Color.Black,
            fontSize = 13.33.sp,
            fontFamily = nunitosansFamily,
            fontWeight = FontWeight.Normal
        ),

        onClick = { offset ->
            annotatedString.getStringAnnotations("login", start = offset, end = offset)
                .firstOrNull().let { annotation ->
                    if (annotation != null) {
                        if (annotation.item == "login") {
                            login()
                        }
                    }
                }
        })
}


@Composable
fun CheckTermsAndcondition(
    toLoginPage: () -> Unit, state: SignUpUiState, onValueChange: (SignUpEvent) -> Unit
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
            checked = state.SignUpchecked,
            onCheckedChange = { onValueChange(SignUpEvent.OnTermsAcceptedChanged(it)) },
            Modifier
                .width(14.dp)
                .height(14.dp)
                .padding(top = 12.dp,end=6.dp),
            colors = CheckboxDefaults.colors(
                checkedColor = colorResource(R.color.red)
            )
        )

        Spacer(Modifier.width(8.dp))

        ClickableText(text = annotatedString,

            style = TextStyle(
                Color.Black,
                fontSize = 11.11.sp,
                fontFamily = nunitosansFamily,
                fontWeight = FontWeight.Normal
            ),

            onClick = { offset ->
                annotatedString.getStringAnnotations(
                        "SignUpTermsAndCondition",
                        start = offset,
                        end = offset
                    ).firstOrNull().let { annotation ->
                        if (annotation != null) {
                            if (annotation.item == "SignUpTermsAndCondition") {
                                toLoginPage()
                            }
                        }
                    }
            })

    }


}


@Preview
@Composable
fun previewsignupAccount() {
    MobileCashAppTheme {

        val viewmodel: MobileCahAppViewModel = hiltViewModel()
        val state = viewmodel.signUpUiState.collectAsState()
        SignUp(
            state.value, viewmodel::OnSignupEvent
        )

    }
}