package com.example.mobilecashapp.presentation

import android.annotation.SuppressLint
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
import androidx.compose.material3.Card
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
fun Login(
    state: LoginUiState,
    event: (LoginEvent) -> Unit
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
            text2 =  stringResource(R.string.Loginsubtitle)
        )

        Spacer(Modifier.height(32.dp))
        DualButton(
        )

        Spacer(Modifier.height(24.dp))

        loginemailandpassword(
            state,
            onValueChange = event
        )
    }

}


@Composable
fun DualButton(
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


        Box(
            modifier = BaseModifiers
                .background(if (Constants.loginSwitch) colorResource(R.color.red) else Color.Transparent)
                .clickable { },
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



        Box(
            modifier = BaseModifiers
                .background(if (Constants.signUpSwitch) colorResource(R.color.red) else Color.Transparent)
                .clickable { },
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

@Composable
fun loginemailandpassword(
    state: LoginUiState,
    onValueChange: (LoginEvent) -> Unit,
) {
    OutlinedTextField(
        value = state.phoneNumber,
        onValueChange = {
            onValueChange(LoginEvent.OnEmailChanged(it))
        },
        Modifier
            .width(350.dp)
            .height(52.dp),
        label = { Text(stringResource(R.string.enter_phone)) },
        shape = RoundedCornerShape(60.dp),
        leadingIcon = {
            Icon(
                painterResource(R.drawable.phone),
                contentDescription = "Phone",
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
                onClick ={ onValueChange(LoginEvent.TogglePasswordVisibility)}
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
    OutlinedTextField(
        value = state.password,
        onValueChange = {
            onValueChange(LoginEvent.OnPasswordChanged(it))
        },
        Modifier
            .width(350.dp)
            .height(52.dp),
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
                painterResource(R.drawable.showandhide)
            }
            else{
                painterResource(R.drawable.baseline_remove_red_eye_24)
            }
            IconButton(
                onClick ={ onValueChange(LoginEvent.TogglePasswordVisibility)}
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
            onCheckedChange = { onValueChange(LoginEvent.OnRememberPassword(state.onRememberPasswordchecked)) },
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
            fontSize = 11.11.sp,
            fontFamily = nunitosansFamily,
            fontWeight = FontWeight.SemiBold

        )

        Spacer(Modifier.weight(1f))

        Text(
            stringResource(R.string.forget_password),
            fontSize = 13.33.sp,
            fontFamily = nunitosansFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.red)

        )
    }

    Spacer(Modifier.height(20.dp))


    SignUp { onValueChange(LoginEvent.signUp) }

    Spacer(Modifier.height(20.dp))
    Button(
        onClick = { onValueChange(LoginEvent.login) },
        modifier = Modifier
            .width(350.dp)
            .height(52.dp)
            .border(
                width = 5.dp,
                color = colorResource(R.color.red).copy(alpha = 0.3f),
                shape = RoundedCornerShape(60.dp)
            ),
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
                                colorResource(R.color.red).copy(alpha = 0.4f),
                                colorResource(R.color.red).copy(alpha = 0.1f)
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

    TermsAndcondition { LoginEvent.terms }


}

@Composable
fun SignUp(
    signUp: () -> Unit
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
    ClickableText(
        text = annotatedString,

        style = TextStyle(
            Color.Black,
            fontSize = 13.33.sp,
            fontFamily = nunitosansFamily,
            fontWeight = FontWeight.Normal
        ),

        onClick = { offset ->
            annotatedString
                .getStringAnnotations("sign_up", start = offset, end = offset)
                .firstOrNull().let { annotation ->
                    if (annotation != null) {
                        if (annotation.item == "sign_up") {
                            signUp()
                        }
                    }
                }
        })
}


@Composable
fun TermsAndcondition(
    termsOnCLicked: () -> Unit
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
    ClickableText(
        text = annotatedString,

        style = TextStyle(
            Color.Black,
            fontSize = 13.33.sp,
            fontFamily = nunitosansFamily,
            fontWeight = FontWeight.Normal
        ),

        onClick = { offset ->
            annotatedString
                .getStringAnnotations("TermsAndCondition", start = offset, end = offset)
                .firstOrNull().let { annotation ->
                    if (annotation != null) {
                        if (annotation.item == "sign_up") {
                            termsOnCLicked()
                        }
                    }
                }
        })
}






@Preview
@Composable
fun previewCreateAccount() {
    MobileCashAppTheme {

        val viewmodel: MobileCahAppViewModel = hiltViewModel()
        val state = viewmodel.createAccountUiState.collectAsState()
        Login(
            state.value,
            viewmodel::OnEvent
        )

    }
}