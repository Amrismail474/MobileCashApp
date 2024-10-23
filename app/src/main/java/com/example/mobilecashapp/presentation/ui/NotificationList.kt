package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.Transaction
import com.example.mobilecashapp.ui.theme.nunitosansFamily


@Composable
fun NotificationList(){
    val trasnations = listOf(
       Transaction("kaylin", "5000","8-2-24","000085752257","card"),
        Transaction("kaylin", "5000","8-2-24","000085752257","card"),
        Transaction("kaylin", "5000","8-2-24","000085752257","card"),
        Transaction("kaylin", "5000","8-2-24","000085752257","card"),
        Transaction("kaylin", "5000","8-2-24","000085752257","card"),
        Transaction("kaylin", "5000","8-2-24","000085752257","card"),
        Transaction("kaylin", "5000","8-2-24","000085752257","card"),
        Transaction("kaylin", "5000","8-2-24","000085752257","card"),
        Transaction("kaylin", "5000","8-2-24","000085752257","card"),
        Transaction("kaylin", "5000","8-2-24","000085752257","card"),
        Transaction("kaylin", "5000","8-2-24","000085752257","card"),
        Transaction("kaylin", "5000","8-2-24","000085752257","card")
    )


    LazyColumn(
        Modifier.background(colorResource(R.color.background))
    ) {
        items(trasnations){transaction->
            Notificationtemplate(
                transaction.amount,transaction.sender
            )

        }
    }
    
    

}



@Composable
fun Notificationtemplate(
    amount:String,
    sender:String
){

        Box(
            modifier = Modifier
                .width(350.dp)
                .height(71.77.dp)
                .clip(
                    RoundedCornerShape(60.dp)).background(Color.White)
            ,
            contentAlignment = Alignment.Center,

        ){
            Row(
                Modifier.fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
            Text(
                stringResource(R.string.notificationmessage,amount,sender,),
                fontSize = 13.33.sp,
                fontFamily = nunitosansFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.AppBlack),
                modifier = Modifier.weight(1f)
            )
            Text(stringResource(R.string.now),
                fontSize = 13.33.sp,
                fontFamily = nunitosansFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.AppBlack),
                textAlign = TextAlign.End)

        }

    }

    Spacer((Modifier.height(16.dp)))

}
@Composable
@Preview
fun NotificationTemPreview(){
    NotificationList()
}
