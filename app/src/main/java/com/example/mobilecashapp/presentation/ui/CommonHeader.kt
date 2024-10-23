package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily

@Composable
fun CommonHeader(
    modifier: Modifier = Modifier,
    text1:String,
    text2:String,
    isextrawords:Boolean = false,
    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.group),
                contentDescription = "Mobile Cash",
                modifier = Modifier.size(48.dp)
            )


            Column(Modifier.padding(8.dp)) {
                Text(
                    stringResource(R.string.mobile_cash),
                    color = colorResource(R.color.red),
                    fontSize = 22.sp, fontWeight = FontWeight.Bold,

                    )


                Text(
                    stringResource(R.string.mobile_cash_subtitle),
                    color = colorResource(R.color.ash), fontSize = 10.sp
                )
            }
        }
        if(isextrawords){
            Box(
                Modifier.padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = text1,
                        Modifier
                            .offset(y = 3.dp)
                            .fillMaxWidth(),
                        fontFamily = poppinsFontFamily,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = colorResource(R.color.AppBlack)
                    )
                    Text(
                        text = text2,
                        Modifier
                            .padding(top = 8.dp)
                            .align(Alignment.CenterHorizontally),
                        color = colorResource(R.color.AppBlack),
                        textAlign = TextAlign.Center,
                        fontSize = 13.33.sp,
                        fontFamily = nunitosansFamily,
                        fontWeight = FontWeight.Normal
                    )
                }

            }
        }

    }
}