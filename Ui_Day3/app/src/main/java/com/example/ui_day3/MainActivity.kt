package com.example.ui_day3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.ui_day3.ui.theme.Ui_Day3Theme

@Composable
fun roundedLeftShape(): Shape {
    val density = LocalDensity.current
    val cornerRadius = with(density) { 12.dp.toPx() }

    return GenericShape { size, _ ->
        moveTo(0f, size.height / 2)
        arcTo(
            rect = Rect(0f, 0f, cornerRadius * 2, cornerRadius * 2),
            startAngleDegrees = 180f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        lineTo(size.width, 0f)
        lineTo(size.width, size.height)
        lineTo(cornerRadius * 2, size.height)
        arcTo(
            rect = Rect(0f, size.height - cornerRadius * 2, cornerRadius * 2, size.height),
            startAngleDegrees = 90f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        close()
    }
}

@Composable
fun RoundedRightShape(): Shape {
    val density = LocalDensity.current
    val cornerRadius = with(density) { 12.dp.toPx() }

    return GenericShape { size, _ ->
        moveTo(0f, 0f)
        lineTo(size.width - cornerRadius, 0f)
        arcTo(
            rect = Rect(size.width - cornerRadius * 2, 0f, size.width, cornerRadius * 2),
            startAngleDegrees = 270f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        lineTo(size.width, size.height - cornerRadius)
        arcTo(
            rect = Rect(
                size.width - cornerRadius * 2,
                size.height - cornerRadius * 2,
                size.width,
                size.height
            ),
            startAngleDegrees = 0f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        lineTo(0f, size.height)
        close()
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ui_Day3Theme {
                Surface(modifier = Modifier.fillMaxSize()) {

                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .size(height = 380.dp, width = 380.dp)
    ) {
        Column(
        ) {
            Headline(
                modifier = Modifier
                    .weight(0.2f)
            )
            Content(
                modifier = Modifier
                    .weight(0.8f)
            )
        }
    }
}

@Composable
fun Headline(modifier: Modifier = Modifier) {
    val iconStyle = IconButtonDefaults.iconButtonColors(contentColor = Color.Gray)
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(
            onClick = {},
            colors = iconStyle,
            modifier = Modifier.weight(0.1F)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                contentDescription = "last month"
            )
        }
        Text(
            text = "July, 2024",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.W800,
            modifier = Modifier.weight(0.8F)
        )
        IconButton(
            onClick = {},
            colors = iconStyle,
            modifier = Modifier.weight(0.1F)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = "next month"
            )
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DaysOfWeekRow(
            modifier = Modifier.weight(0.1f)
        )
        DaysGrid(modifier = Modifier.weight(0.8f), 10, 19)
    }
}

@Composable
fun DaysGrid(modifier: Modifier = Modifier, firstDay: Int, lastDay: Int) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        val firstColor = Color(0xFF7D58FB)
        val secondColor = Color(0xFFCBBEF7)
        var currentDay = 1
        var style = TextStyle(color = Color.Black)
        for (i in 1..5) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top
            ) {
                for (j in 1..7) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .then(
                                when (currentDay) {
                                    firstDay -> Modifier
                                        .clip(roundedLeftShape())
                                        .background(firstColor)

                                    lastDay -> Modifier
                                        .clip(RoundedRightShape())
                                        .background(firstColor)

                                    in (firstDay + 1)..<lastDay -> Modifier
                                        .background(secondColor)

                                    else -> Modifier
                                }
                            )
                    ) {
                        Text(
                            text = currentDay.toString(),
                            fontWeight = FontWeight.W700,
                            style = style,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.Center)

                        )
                    }
                    currentDay++
                    if (currentDay > 31) {
                        style = TextStyle(color =
                        when (currentDay) {
                            firstDay, lastDay -> Color.White
                            in (firstDay + 1)..<lastDay -> firstColor
                            in 32..Int.MAX_VALUE -> Color.Gray
                            else -> Color.Black
                        })
                        currentDay = 1
                    }
                }
            }
        }
    }
}

@Composable
fun DaysOfWeekRow(modifier: Modifier = Modifier) {
    val daysOfWeek = listOf('M', 'T', 'W', 'T', 'F', 'S', 'S')
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        for (day in daysOfWeek) {
            Box(
                modifier = Modifier.size(50.dp)
            ) {
                Text(
                    text = day.toString(),
                    fontWeight = FontWeight.W700,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainScreen(modifier = Modifier.padding(8.dp))
    }
}