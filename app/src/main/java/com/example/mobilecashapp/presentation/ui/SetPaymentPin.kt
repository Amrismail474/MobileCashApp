package com.example.mobilecashapp.presentation.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilecashapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PinInputField(
    value: String,
    onValueChange: (String) -> Unit,
    isClicked: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .width(81.dp)
            .height(61.dp)
            .padding(2.dp),
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = if (isClicked) colorResource(R.color.red) else Color.White,
            unfocusedBorderColor =  Color.White,
            cursorColor = Color.Black
        ),
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun PinInputRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val pinLength = 4
        var pin by remember { mutableStateOf("") }

        // Render multiple PinInputFields
        for (i in 0 until pinLength) {
            PinInputField(
                value = if (i < pin.length) pin[i].toString() else "",
                onValueChange = { newValue ->
                    if (newValue.length <= pinLength) {
                        pin = newValue
                    }
                },
                isClicked = false // Set to true if you want the red error border
            )
        }
    }
}


@Composable
fun PinInput(pinLength: Int = 4) {
    var pin by remember { mutableStateOf("") } // Starts empty
    var activeBox by remember { mutableStateOf(-1) } // Tracks which box is active

    Row {
        for (i in 0 until pinLength) {
            // Each box is a TextField with borders that change on click
            OutlinedTextField(
                value = if (i < pin.length) pin[i].toString() else "", // Shows the entered number or empty
                onValueChange = { newValue ->
                    if (newValue.length <= 1) { // Allows input of only one digit per box
                        pin = pin.substring(0, i) + newValue + pin.substring(i + 1)
                        if (newValue.isNotEmpty() && i < pinLength - 1) {
                            activeBox = i + 1 // Move to the next box after input
                        }
                    }
                },
                modifier = Modifier
                    .width(52.dp)
                    .height(52.dp)
                    .padding(4.dp)
                    .border(
                        width = 2.dp,
                        color = if (activeBox == i) Color.Red else Color.Gray, // Change border color based on active box
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable {
                        activeBox = i // Set the clicked box as active
                    },
                singleLine = true,
                maxLines = 1
            )
        }
    }
}



@Composable
@Preview
fun SetPasswordPreview(){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        PinInput()

    }
}
