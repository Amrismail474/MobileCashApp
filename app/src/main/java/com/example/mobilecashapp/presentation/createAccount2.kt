package com.example.mobilecashapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Brush
import com.example.mobilecashapp.R

@Composable
fun MobileCashLoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo or Image
        Image(
            painter = painterResource(id = R.drawable.group_66), // Replace with your drawable
            contentDescription = "Mobile Cash Logo",
            modifier = Modifier.size(100.dp), // Adjust size as per your design
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Welcome text
        Text(
            text = "Welcome to Mobile Cash",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Subtitle text
        Text(
            text = "Experience seamless transactions\nwith Mobile Cash.",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Email/Phone input
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Enter Phone number") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.arrow), // Replace with your icon
                    contentDescription = null
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password input
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Enter your password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_24), // Replace with your icon
                    contentDescription = null
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Forgot password
        Text(
            text = "Forgot Password?",
            fontSize = 14.sp,
            color = Color.Red,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Login button
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),


        ) {
            Text(text = "Login", fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign up text
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Don't have an account? ", fontSize = 14.sp)
            Text(
                text = "Click here to sign up",
                fontSize = 14.sp,
                color = Color.Red,
                textDecoration = TextDecoration.Underline
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Terms of service and privacy policy
        Text(
            text = "By signing up, you agree to our Terms of services\nand Privacy policy",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMobileCashLoginScreen() {
    MobileCashLoginScreen()
}
