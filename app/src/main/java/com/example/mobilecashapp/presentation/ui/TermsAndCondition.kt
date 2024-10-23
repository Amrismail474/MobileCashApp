package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecashapp.R
import com.example.mobilecashapp.ui.theme.nunitosansFamily


@Composable
fun TermsAndCondition(
   navController: NavController
){
    Scaffold(topBar = {
        GeneralTopAppBar(stringResource(R.string.termsandcondition),navController)
    }) { paddingValues->
    Column(
        Modifier.fillMaxSize()
            .background(color = colorResource(R.color.background))
            .padding(paddingValues).padding(horizontal = 6.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
    TermsAndConditionComponent1()
    }
}
}



@Composable
fun TermsAndConditionComponent1(){
    TermsAndConditionTemplate(
        " Account Creation and Security",
        "Users are required to provide accurate and complete information during the account creation process. Users are solely responsible for maintaining the confidentiality and security of their account credentials. Any unauthorized use of the account should be immediately reported."
    )
    TermsAndConditionTemplate(
        " Service Description",
            "Mobile Cash provides a platform for peer-to-peer payments along with other financial services. The exact services and features offered may evolve over time. Users will be informed of any modifications to the services."
            )
    TermsAndConditionTemplate(
        "Fees",
        "Some transactions or services offered by Mobile Cash may incur fees. Users will be informed of any applicable fees before completing the transaction."
    )
    TermsAndConditionTemplate(
        " User Conduct",
        "Users agree to use Mobile Cash in a legal and responsible manner. Any use of the platform for illegal or unauthorized purposes is strictly prohibited."
    )

    TermsAndConditionTemplate(
        "Disclaimer of Warranties",
        "Mobile Cash is provided on an \"as is\" basis without any warranties, either express or implied. We make no guarantees regarding the availability, functionality, or performance of the service."
    )

    TermsAndConditionTemplate(
        " Limitation of Liability",
        "Mobile Cash limits its liability for any damages that arise from the use of the platform. Users agree that Mobile Cash will not be held responsible for any indirect, incidental, or consequential damages."
    )

    TermsAndConditionTemplate(
        "Data Privacy",
        "We are committed to protecting your privacy and will handle your personal information in accordance with our Privacy Policy, ensuring that it remains secure."
    )

    TermsAndConditionTemplate(
        "Changes to Terms",
        "Mobile Cash reserves the right to modify these terms and conditions at any time. Users will be notified of any significant changes to the terms."
    )

    TermsAndConditionTemplate(
        " Dispute Resolution",
        "In case of any disputes arising from the use of Mobile Cash, the matter will be resolved through mediation, arbitration, or legal proceedings, as applicable."

    )
}

@Composable
fun TermsAndConditionTemplate(
    title:String,
    subtitle:String
){

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 19.2.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontFamily = nunitosansFamily
        )

        Spacer(Modifier.height(8.dp))
        Text(
            text = subtitle,
            fontSize = 13.33.sp,
            color = Color.Black,
            fontWeight = FontWeight.Light,
            fontFamily = nunitosansFamily
        )
        Spacer(Modifier.height(16.dp))


    }

}

@Composable
@Preview
fun TermsAndConditionPreview(){
    val navController:NavController= rememberNavController()
    TermsAndCondition(navController)
}