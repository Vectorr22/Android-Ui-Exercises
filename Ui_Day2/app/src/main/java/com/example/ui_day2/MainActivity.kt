package com.example.ui_day2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_day2.ui.theme.Ui_Day2Theme
import androidx.compose.ui.graphics.Color as Colorsito

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ui_Day2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    val brush = Brush.horizontalGradient(
        listOf(
            Colorsito(0xFF8D05BD),
            Color.Yellow
        )
    )
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Colorsito(0xFF8D05BD)
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize()
        ) {
            Column(
                modifier = Modifier
                    .width(300.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Save 66%",
                        color = Colorsito(0xFF8D05BD),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Default,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 12.dp)
                    )
                    IconButton(onClick = {}, modifier = Modifier.align(Alignment.TopEnd)) {
                        Icon(imageVector = Icons.Rounded.Close, contentDescription = "close popup")
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(
                            width = 4.dp,
                            brush = brush,
                            shape = RoundedCornerShape(16.dp)
                        )

                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.6f)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "Yearly plan", color = Colorsito(0xFF8D05BD),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "12 mo $79.99",
                            color = Colorsito(0xFF8D05BD),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                    Box(
                        modifier = Modifier.weight(0.4f).padding(12.dp)
                    ) {
                        Text(
                            text = "$6.99 / mo",
                            color = Colorsito(0xFF8D05BD),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)

                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalArrangement = Arrangement.SpaceAround
                )
                {
                    Text(text = "Monthly", fontSize = 14.sp, modifier = Modifier.padding(4.dp), color = Color.Gray)
                    Spacer(modifier = Modifier.width(70.dp))
                    Text(text = "$19.99 / mo", modifier = Modifier.padding(4.dp), fontSize = 14.sp, color = Color.Gray)
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(brush)
                        .wrapContentHeight()
                )
                {
                    Text(text = "Get the offer", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ui_Day2Theme {
        MainScreen()
    }
}