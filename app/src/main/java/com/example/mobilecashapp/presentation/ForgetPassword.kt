package com.example.mobilecashapp.presentation

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.MobileCashAppTheme
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily


@Composable
fun ForgetPassword(
    state: ForgetpasswordUiState,
    event: (ForgetpasswordEvent) -> Unit
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CommonHeader(
            text1 = stringResource(R.string.ForgetpasswordText),
            text2 =  stringResource(R.string.Forgetpasswordsubtitle)
        )
        ForgetPasswordContent(
            state,
            onValueChange = event
        )
    }

}


@Composable
fun ForgetPasswordContent(
    state: ForgetpasswordUiState,
    onValueChange:(ForgetpasswordEvent)->Unit
){
        Box(
            Modifier.padding(8.dp),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(R.drawable.forgetpassword_image),
                contentDescription = null,

                )
        }


        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = state.phoneNumber,
            onValueChange = {
                onValueChange(ForgetpasswordEvent.onPhoneNumberChanged(it))
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

        )

    Spacer(Modifier.height(4.dp))

        Button(
            onClick = { onValueChange(ForgetpasswordEvent.continu) },
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
                        if (state.phoneNumber.isEmpty()) {
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
                    text = stringResource(R.string.continu),
                    color = Color.White,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Button(
            onClick = { onValueChange(ForgetpasswordEvent.cancel) },
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







@Preview
@Composable
fun previewForgetPassword() {
    MobileCashAppTheme {

        val viewmodel: MobileCahAppViewModel = hiltViewModel()
        val state = viewmodel.forgetpassword.collectAsState()

        ForgetPassword(state.value,viewmodel::OnforgetPassword)
    }
}








