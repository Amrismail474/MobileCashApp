package com.example.mobilecashapp.presentation.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.MobileCashAppTheme
import com.example.mobilecashapp.ui.theme.nunitosansFamily
import com.example.mobilecashapp.ui.theme.poppinsFontFamily


@Composable
fun PaymentDeclinedDialog(
) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .width(330.dp)
                .height(292.dp)
                .align(Alignment.Center),
            colors = CardDefaults.cardColors(Color.White)
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
                    Box(
                        modifier = Modifier
                            .size(72.dp),
                        contentAlignment = Alignment.Center,

                        ){


                        Icon(
                            painter = painterResource(id = R.drawable.erroremojitemplate),
                            contentDescription = null,
                            tint = colorResource(R.color.red),
                            modifier = Modifier.size(72.dp)
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.failedemoji),
                            contentDescription = null,
                            modifier = Modifier.width(46.22.dp).height(46.22.dp).align(Alignment.Center).padding(top=8.dp),
                            tint = Color.Unspecified
                        )

                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.paymentDeclined),
                        fontSize = 19.2.sp,
                        fontFamily = nunitosansFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(R.color.red),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.paymentDeclinedsubtitle),
                        fontSize = 13.33.sp,
                        fontFamily = nunitosansFamily,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(R.color.ash),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPaymentDialog() {
    MobileCashAppTheme {
       PaymentDeclinedDialog()

    }
}
