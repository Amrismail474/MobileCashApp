package com.example.mobilecashapp.presentation.ui

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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.Graph
import com.example.mobilecashapp.ui.theme.MobileCashAppTheme
import com.example.mobilecashapp.ui.theme.poppinsFontFamily
import kotlinx.coroutines.delay


@Composable
fun SuccessDialog(
    text: String,
    navController: NavController
){
    LaunchedEffect(Unit) {
        delay(50000000)
        navController.navigate(Graph.Home.title)
    }

    SuccessDialogTemplate(text)
}

@Composable
fun SuccessDialogTemplate(text:String) {

    Dialog(
        onDismissRequest ={ }
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
                        Icon(
                            painter = painterResource(id = R.drawable.checkmark),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(99.96.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = text,
                            fontSize = 19.2.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(R.color.AppBlack),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }


}}

@Preview
@Composable
fun PreviewsuccessDialog() {
    MobileCashAppTheme {
        val navController:NavController= rememberNavController()
        SuccessDialog(stringResource(R.string.successText),navController)

    }
}
