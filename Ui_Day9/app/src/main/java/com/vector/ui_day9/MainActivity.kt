package com.vector.ui_day9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vector.ui_day9.ui.theme.Ui_Day9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ui_Day9Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            DoctorInfo()
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                CardInfoDetail(
                    "500+",
                    "Patients in Mindbridge",
                    "Go to reviews"
                )
                CardInfoDetail(
                    "8",
                    "Certifications & Education",
                    "Go to Certifications"
                )
            }
        }
    }
}

@Composable
fun DoctorInfo(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.pp),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Dr. Emily Parker",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Clinical Psychologist",
                fontWeight = FontWeight.W500,
                fontSize = 15.sp
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(125.dp),
        ){
            IconButton(onClick = {}, modifier = Modifier.align(Alignment.TopEnd)) {
                Icon(imageVector = Icons.Rounded.Close, contentDescription = "Close")
            }
        }
    }
}

@Composable
fun CardInfoDetail(
    firstText: String,
    secondText: String,
    goToText: String,
    modifier: Modifier = Modifier
) {
    val colors = listOf(
        Color(0xFF172957),
        Color(0xFF277892),
        Color(0xFF174086),
        Color(0xFF2066CB),
        Color(0xFF258CA5)
    )
    val background = Brush.linearGradient(
        colors = colors
    )
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        ),
        modifier = modifier
            .width(170.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                brush = background
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = firstText,
                textAlign = TextAlign.Center
            )
            Text(
                text = secondText,
                textAlign = TextAlign.Center
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = goToText,
                    fontSize = 10.sp,
                    color = Color(0xFFDAD7D7),
                    textAlign = TextAlign.Center
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .height(20.dp)
                ) {
                    Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = "move to section")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Ui_Day9Theme {
        MainScreen(modifier = Modifier.padding(20.dp))
    }
}

@Preview
@Composable
private fun SideItemPreview() {
    Ui_Day9Theme {
        //DoctorInfo()
        CardInfoDetail(
            "500+",
            "Patients in Mindbridge",
            "Go to reviews",
            modifier = Modifier.padding(8.dp))
    }
}