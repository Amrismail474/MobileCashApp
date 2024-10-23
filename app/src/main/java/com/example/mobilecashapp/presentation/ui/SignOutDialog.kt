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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun SignOutDialog(
    text: String,
    subtitle:String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier =
        Modifier
            .fillMaxSize()
            .background(Color(0x80000000))
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .width(330.dp)
                .height(408.dp)
                .align(Alignment.Center),
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(72.dp),
                        contentAlignment = Alignment.Center,

                        ){

                        Icon(
                            painter = painterResource(id = R.drawable.group_34214),
                            contentDescription = null,
                            tint = colorResource(R.color.red),
                            modifier = Modifier.size(72.dp)
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.logout),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp).align(Alignment.Center).padding(top=4.dp),
                            tint = Color.Unspecified
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = text,
                        fontSize = 19.2.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(R.color.AppBlack),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = subtitle,
                        fontSize = 13.33.sp,
                        fontFamily = nunitosansFamily,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(R.color.AppBlack),
                        textAlign = TextAlign.Center
                    )

                    Spacer(Modifier.height(16.dp))

                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ){
                        Button(
                            onClick = { },
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
                                    text = stringResource(R.string.signout),
                                    color = Color.White,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }


                        Button(
                            onClick = { },
                            modifier = Modifier
                                .width(350.dp)
                                .height(52.dp)
                                .border(
                                    width = 5.dp,
                                    color = colorResource(R.color.white).copy(alpha = 0.3f),
                                    shape = RoundedCornerShape(60.dp)
                                ) .padding(4.dp),

                            shape = RoundedCornerShape(60.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = colorResource(R.color.red)
                            ),
                            contentPadding = PaddingValues()
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        SolidColor(Color.White),
                                        shape = RoundedCornerShape(60.dp)
                                    ).clip(RoundedCornerShape(60.dp))
                                    .fillMaxSize(), contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = stringResource(R.string.cancel),
                                    color = colorResource(R.color.red),
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight.Medium,
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
}

@Composable
@Preview
fun SignOutPreview(){
    SignOutDialog(
        "Confirm Sign out ?",
        "Please confirm if you want to \n" +
                "sign out of your account"
    )

}

