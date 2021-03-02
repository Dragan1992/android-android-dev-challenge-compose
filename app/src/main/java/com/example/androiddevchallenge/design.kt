package com.example.androiddevchallenge

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun Toolbar(title:String) {
    Column() {
        Surface(
            Modifier
                .fillMaxWidth()
                .height(200.dp), color = MaterialTheme.colors.secondary,
            elevation = 8.dp, shape = RoundedCornerShape(0, 0, 15, 15)
        ) {
            Column(
                Modifier.fillMaxSize()
                    .padding(5.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title, color = Color.White,
                    style = MaterialTheme.typography.h4
                )
            }

        }
    }
}