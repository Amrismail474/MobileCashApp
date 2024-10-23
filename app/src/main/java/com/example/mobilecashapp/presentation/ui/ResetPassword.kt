package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
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
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.viewmodel.MobileCahAppViewModel
import com.example.mobilecashapp.presentation.events.ResetPasswordEvent
import com.example.mobilecashapp.presentation.state.ResetPasswordUiState
import com.example.mobilecashapp.ui.theme.poppinsFontFamily


@Composable
fun ResetPassword(
    state: ResetPasswordUiState,
    event: (ResetPasswordEvent)->Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.background))
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        CommonHeader(
            text1 = stringResource(R.string.resetpassword),
            text2 = stringResource(R.string.resetpasswordsubtitle),
            isextrawords = true
        )
        Spacer(Modifier.height(30.dp))
        ResetpasswordContent(
            state,
            event
        )
        Spacer(Modifier.weight(1f))

        ResetpasswordButton(state,event)



    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetpasswordContent(
    state: ResetPasswordUiState,
    OnEvent : (ResetPasswordEvent)->Unit
){

    OutlinedTextField(
        value = state.password,
        onValueChange = {
            OnEvent(ResetPasswordEvent.OnPassword(it))
        },
        Modifier
            .width(350.dp)
            .height(52.dp)
        , colors = TextFieldDefaults.outlinedTextFieldColors(
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
                onClick ={ ResetPasswordEvent.TogglePasswordVisibility }
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
    OutlinedTextField(
        value = state.password,
        onValueChange = {
            OnEvent(ResetPasswordEvent.OnConfirmPasswordChanged(it))
        },
        Modifier
            .width(350.dp)
            .height(52.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
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
                onClick ={ OnEvent(ResetPasswordEvent.TogglePasswordVisibility)}
            ) {
                Icon(
                    icon,
                    contentDescription = "Show Password"
                )
            }
        },
        visualTransformation =
        if (state.passwordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),


        )






}

@Composable
fun ResetpasswordButton(
    state: ResetPasswordUiState,
    OnEvent:(ResetPasswordEvent)->Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { OnEvent(ResetPasswordEvent.continu) },
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
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        if (state.password.isEmpty()) {
                            Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.red).copy(alpha = 0.7f),
                                    colorResource(R.color.red).copy(alpha = 0.7f)
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
                    text = stringResource(R.string.continu),
                    color = Color.White,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        Button(
            onClick = { OnEvent(ResetPasswordEvent.cancel) },
            modifier = Modifier
                .width(350.dp)
                .height(52.dp),
            colors =
            ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = colorResource(R.color.red)
            )
        ) {
            Text(
                text = stringResource(R.string.cancel),
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
fun showResetpassword(){

    val viewmodel: MobileCahAppViewModel = hiltViewModel()
    val state = viewmodel.resetpassword.collectAsState()

    ResetPassword(state.value,viewmodel::OnResetPassword)

}