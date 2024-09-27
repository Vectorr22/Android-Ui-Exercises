package com.example.ui_day4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_day4.ui.theme.Ui_Day4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ui_Day4Theme {
                Scaffold(
                    containerColor = Color(0xFFE3F2FD)
                ) { paddingValues ->
                    Box(modifier = Modifier.fillMaxSize()){
                        MainScreen(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val gradient = Brush.linearGradient(listOf(Color.Blue, Color.Black))
    Card(
        modifier = modifier
            .size(
                width = 350.dp,
                height = 200.dp
            )
            .clip(RoundedCornerShape(12.dp))
            .background(gradient),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
    ) {
        val cardStyle = TextStyle(color = Color.White, fontFamily = FontFamily.SansSerif)
        val numberCardStyle =
            TextStyle(color = Color.White, fontFamily = FontFamily.SansSerif, letterSpacing = 6.sp)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = "Debit",
                style = cardStyle,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.12f)
                    .padding(bottom = 8.dp)
            )
            Text(
                text = "3782 8244 4733 1229",
                style = numberCardStyle,
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f),
            ) {
                Box(modifier = Modifier.fillMaxSize())
                {
                    Column(
                        modifier = Modifier.align(Alignment.BottomStart)
                    ) {
                        val color = Color(0xFFC7C7C7)
                        Text(
                            text = "Expire 08/25",
                            style = cardStyle,
                            fontSize = 12.sp,
                            color = color,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = "William S.",
                            style = cardStyle,
                            fontSize = 16.sp
                        )
                    }
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth(0.32f)
                            .align(Alignment.BottomEnd)
                            .padding(16.dp)
                    ) {
                        drawCircle(Color.White, radius = 20.dp.toPx())
                    }
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth(0.19f)
                            .align(Alignment.BottomEnd)
                            .padding(16.dp)
                    ) {
                        drawCircle(Color.White, radius = 19.dp.toPx(), style = Stroke(5f))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        MainScreen(modifier = Modifier.align(Alignment.Center))
    }
}

