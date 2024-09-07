package com.example.mobilecashapp.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.MobileCashAppTheme



@Composable
fun FrontPage(modifier: Modifier=Modifier){
    Box(contentAlignment = Alignment.Center, modifier =  modifier.fillMaxSize().background(Color.White)){
        Row (modifier=modifier.fillMaxWidth().height(500.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(R.drawable.group),
                    contentDescription = "Mobile Cash",
                   // modifier = Modifier.shadow(24.dp, clip = false)

                    )


                    Column(Modifier.padding(10.dp)) {
                        Text(stringResource(R.string.mobile_cash),
                            color = colorResource(R.color.red),
                            fontSize = 22.sp, fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelSmall.copy(
                                shadow = Shadow(
                                    color= colorResource(R.color.black),
                                    offset = Offset(2f,4f),
                                    blurRadius = 0.0005f
                                )
                            )
                            //modifier = Modifier.shadow(24.dp, clip = false),
                        )


                        Text(stringResource(R.string.mobile_cash_subtitle),
                            color = colorResource(R.color.ash), fontSize = 10.sp,
                          modifier = Modifier.shadow(24.dp, clip = false)
                        )
                    }


        }


    }
}

@Preview
@Composable
fun previw(){
    MobileCashAppTheme {
        FrontPage()
    }
}
