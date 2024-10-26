package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.viewmodel.MobileCahAppViewModel
import com.example.mobilecashapp.presentation.constants.User
import com.example.mobilecashapp.presentation.events.OtpUiEvent
import com.example.mobilecashapp.presentation.state.OtpUiState
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily
import kotlinx.coroutines.delay


@Composable
fun Otp(
        state: OtpUiState,
        event: (OtpUiEvent) -> Unit
    ){
    val user = User("AL-HASSAN" ,"SOLATE",
        R.drawable.ellipse_9,"hassansolate202@gmail.com",
        "08052377416","0431609284","18,952.7")

    val masked = maskOtpPhoneNumber(user.phone)
    Scaffold {innerPadding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.background))
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            CommonHeader(
                text1 = stringResource(R.string.VerificationText),
                text2 =  stringResource(R.string.Verificatonsubtitle,masked),
                isextrawords = true
            )

            OtpBox(state,event)
            Spacer(Modifier.height(30.dp))
            OtpButton(state)
            OtpLink()
            OtpKeypad(state, event)
        }

    }


    }


@Composable
fun OtpBox(
    state: OtpUiState,
    onOtpEvent: (OtpUiEvent) -> Unit
) {
    val focusRequester = List(4) { FocusRequester() }

    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.padding(vertical = 16.dp)
    ) {

        repeat(4) { index ->
            var isFocused by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = if (state.otp.length > index) state.otp[index].toString() else "",
                onValueChange = { input ->
                    if (input.length == 1) {
                        val newOtp = state.otp.toCharArray().apply { this[index] = input[0] }.concatToString()
                        onOtpEvent(OtpUiEvent.onOtpEntered(newOtp))

                        if (index < 3) {
                            focusRequester[index + 1].requestFocus()
                        } else {
                            onOtpEvent(OtpUiEvent.OtpCompleted)
                        }
                    }
                },
                placeholder = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ellipse_17),
                            contentDescription = "OTP dot icon",
                            modifier = Modifier.size(10.dp),
                            tint = colorResource(R.color.otpdot)
                        )
                    }
                },
                modifier = Modifier
                    .size(81.dp, 61.dp)
                    .border(
                        BorderStroke(2.dp, if (isFocused) colorResource(R.color.red) else colorResource(R.color.ash)),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .focusRequester(focusRequester[index])
                    .onFocusChanged { focusState -> isFocused = focusState.isFocused },
                shape = RoundedCornerShape(15.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                visualTransformation = PasswordVisualTransformation()
            )
        }
    }


    LaunchedEffect(state.otp) {
        if (state.otp.isEmpty()) {
            delay(300)
            focusRequester[0].requestFocus()
        }
    }
}


@Composable
fun OtpButton(
    state: OtpUiState
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { },
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
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(),
            enabled = state.otp.length==4
        ) {
            Box(
                modifier = Modifier
                    .background(
                        if (state.otp.length == 4) {
                            SolidColor(colorResource(R.color.red))
                        } else {
                            Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.red).copy(alpha = 0.7f),
                                    colorResource(R.color.red).copy(alpha = 0.7f)
                                )
                            )
                        },
                        shape = RoundedCornerShape(60.dp)
                    )
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,

            ) {
                Text(
                    text = stringResource(R.string.verifyNow),
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

@Composable
fun OtpLink(
) {
    val fullText = stringResource(R.string.recieve_code)
    val clickable = stringResource(R.string.resend_code)


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
                        if (annotation.item == "login") { }
                    }
                }
        })
}

fun maskOtpPhoneNumber(phoneNumber: String): String {

    if (phoneNumber.length < 10) return phoneNumber

    val firstPart = phoneNumber.take(5)


    val maskedPart = "*".repeat(phoneNumber.length - 7)

    return "$firstPart$maskedPart"
}


@Composable
fun OtpKeyButton(
    text: String,
    onClick: () -> Unit,
    state: OtpUiState
    ) {

    Box(
        modifier = Modifier
            .width(109.dp).height(67.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(colorResource(R.color.white))
            .border(1.dp,
                if(state.isclicked)Color.Red else Color.Unspecified,
                RoundedCornerShape(15.dp))
            .clickable {
                onClick()
                       },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = poppinsFontFamily,
            fontSize = 19.2.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(R.color.red)

        )
    }
}


@Composable
fun OtpKeypad(
    state: OtpUiState,
    event:(OtpUiEvent)->Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(9.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        val numbers = listOf(
            listOf("1", "2", "3"),
            listOf("4", "5", "6"),
            listOf("7", "8", "9"),
            listOf("", "0", "⌫") // Empty string for blank space
        )

        for (row in numbers) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(9.dp),
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (item in row) {
                    if (item.isEmpty()) {
                        Spacer(modifier = Modifier.width(110.dp))
                    } else {
                        OtpKeyButton(
                            text = item,
                            onClick = {
                                if (item == "⌫") {
                                    event(OtpUiEvent.onDeleteClicked)
                                } else {
                                    event(OtpUiEvent.OtpCompleted)
                                }},
                            state
                        )

                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun OtpPreview(){
    val viewmodel: MobileCahAppViewModel = hiltViewModel()
    val state = viewmodel.otp.collectAsState()

  Otp(state.value) { }


}