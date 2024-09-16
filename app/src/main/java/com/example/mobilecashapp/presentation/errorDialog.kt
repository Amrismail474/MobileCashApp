package com.example.mobilecashapp.presentation

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.MobileCashAppTheme
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily


@Composable
fun errorDialog(){
    Box(
        contentAlignment = Alignment.Center,
        modifier =
        Modifier.fillMaxSize().background(Color(0x80000000))
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .width(330.dp)
                .height(292.dp)
                .align(Alignment.Center),
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ){
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize().padding(16.dp)
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.cancel),
                        contentDescription = null,
                        tint = colorResource(R.color.red).copy(alpha = 0.5f),
                        modifier = Modifier.size(99.96.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.errorText),
                        fontSize = 13.3.sp,
                        fontFamily = nunitosansFamily,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(R.color.ash),
                        textAlign = TextAlign.Center
                    )


                    Spacer(Modifier.height(20.dp))
                    Button(
                        onClick = {  },
                        modifier = Modifier
                            .width(286.dp)
                            .height(56.dp)
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
                                .background(SolidColor(colorResource(R.color.red)),
                                    shape = RoundedCornerShape(30.dp)
                                )
                                .size(256.dp,47.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = stringResource(R.string.okay),
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
        }
    }
}

@Preview
@Composable
fun previewerrorDialog() {
    MobileCashAppTheme {
        errorDialog ()

    }
}
