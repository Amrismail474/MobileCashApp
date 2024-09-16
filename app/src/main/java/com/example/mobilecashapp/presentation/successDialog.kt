package com.example.mobilecashapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.mobilecashapp.ui.theme.poppinsFontFamily


@Composable
fun SuccessDialog() {
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
                .height(292.dp)
                .align(Alignment.Center),
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.checkmark),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(99.96.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.successText),
                        fontSize = 19.2.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(R.color.Loginblack),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun previewsuccessDialog() {
    MobileCashAppTheme {
        SuccessDialog ()

    }
}
