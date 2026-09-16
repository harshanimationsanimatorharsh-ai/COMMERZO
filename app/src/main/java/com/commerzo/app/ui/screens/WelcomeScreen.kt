package com.commerzo.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.commerzo.app.R

@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B0B0F)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.commerzo_launcher_icon),
                contentDescription = "COMMERZO Logo",
                modifier = Modifier
                    .size(150.dp)
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Welcome to COMMERZO",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Learn. Practice. Grow.",
                color = Color(0xFFBDB9D9),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Founded by Mr.Harsh Shrivas",
                color = Color(0xFFD6B36A),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
