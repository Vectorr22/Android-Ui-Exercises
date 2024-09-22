package com.example.ui_day7

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_day7.ui.theme.Ui_Day7Theme

private val color = Color(0xFF3A3441)
private val colorPressed = Color(0xFFA179D1)
private val contentColorPressed = Color(0xFF451181)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ui_Day7Theme {
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
fun MainScreen(modifier: Modifier = Modifier) {
    var currentSearchText by remember { mutableStateOf("") }
    ElevatedCard(
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.portrait),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Welcome back",
                            fontSize = 15.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Noah Blank",
                            fontSize = 22.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                TextField(
                    value = currentSearchText,
                    onValueChange = { currentSearchText = it },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = color,
                        unfocusedContainerColor = color
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Search",
                            color = Color.White
                        )
                    },
                    shape = RoundedCornerShape(28.dp),
                    singleLine = false,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                for (i in 0..3) {
                    val currentButton = listOfButtons[i]
                    ButtonApp(buttonInfo = currentButton)
                }
                Spacer(modifier = Modifier.height(15.dp))
                ButtonApp(buttonInfo = listOfButtons[4])
                Spacer(modifier = Modifier.height(15.dp))
                for (i in 5..7) {
                    val currentButton = listOfButtons[i]
                    ButtonApp(buttonInfo = currentButton)
                }
            }
            ButtonApp(
                buttonInfo = listOfButtons.last(),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun ButtonApp(modifier: Modifier = Modifier, buttonInfo: ButtonInfo) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = if(isPressed) colorPressed else color,
            contentColor = if(isPressed) contentColorPressed else Color.White
        ),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
        interactionSource = interactionSource,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = buttonInfo.iconResource),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = buttonInfo.description,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                        .align(Alignment.CenterEnd)
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    Ui_Day7Theme(
        darkTheme = true
    ) {
        MainScreen()
    }
}

@Preview
@Composable
private fun ButtonAppPreview() {
    ButtonApp(buttonInfo = listOfButtons.first())
}

data class ButtonInfo(
    @DrawableRes val iconResource: Int,
    val description: String,
)

val listOfButtons = listOf(
    ButtonInfo(R.drawable.transfer, "Transfer funds"),
    ButtonInfo(R.drawable.creditcard, "Cards"),
    ButtonInfo(R.drawable.dollar, "Investments"),
    ButtonInfo(R.drawable.statistics, "Statistics"),
    ButtonInfo(R.drawable.user, "Profile"),
    ButtonInfo(R.drawable.padlock, "Security"),
    ButtonInfo(R.drawable.settings, "Settings"),
    ButtonInfo(R.drawable.help, "Help Center"),
    ButtonInfo(R.drawable.logout, "Log out")
)