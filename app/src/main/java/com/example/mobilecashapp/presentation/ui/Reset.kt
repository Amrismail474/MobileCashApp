package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.viewmodel.MobileCahAppViewModel
import com.example.mobilecashapp.presentation.events.ResetPasswordEvent
import com.example.mobilecashapp.presentation.state.ResetState
import com.example.mobilecashapp.ui.theme.poppinsFontFamily


@Composable
fun Reset(
    state: ResetState,
    navController: NavController
){

    Scaffold(
        topBar = { GeneralTopAppBar("Reset",navController) },
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

            ResetSection1(state)
            Spacer(Modifier.weight(1f))
            ResetSection2()
        }
        }

    }









@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetSection1(
    state:ResetState
){

    Spacer(Modifier.height(20.dp))

    OutlinedTextField(
        value = state.password,
        onValueChange = {},
        Modifier
            .width(350.dp)
            .height(52.dp)
        , colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray
        ),
        label = { Text(stringResource(R.string.password)) },
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
    Spacer(Modifier.height(25.dp))
    OutlinedTextField(
        value = state.password,
        onValueChange = {},
        Modifier
            .width(350.dp)
            .height(52.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray
        ),
        label = { Text(stringResource(R.string.new_password)) },
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

    Spacer(Modifier.height(25.dp))
    OutlinedTextField(
        value = state.password,
        onValueChange = {},
        Modifier
            .width(350.dp)
            .height(52.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray
        ),
        label = { Text(stringResource(R.string.confirm_new_password)) },
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
}

@Composable
fun ResetSection2(){
    Row(
        Modifier.offset(y= (-90).dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,

    ){
        Button(
            onClick = {  },
            modifier = Modifier
                .width(350.dp)
                .height(52.dp)
                .border(
                    width = 5.dp,
                    color = colorResource(R.color.red).copy(alpha = 0.5f),
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
                        SolidColor(colorResource(R.color.red)),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .size(340.dp,42.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.reset),
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

@Preview
@Composable
fun ResetPreview(){
    val viewModel: MobileCahAppViewModel = hiltViewModel()
    val state = viewModel.resetState.collectAsState()
    val navController:NavController= rememberNavController()
    Reset(state.value,navController)
}