package com.example.ui_day1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_day1.ui.theme.UI_Day1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UI_Day1Theme {
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        var input by remember { mutableStateOf("") }
        var input2 by remember { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(false) }
        val gradient = Brush.horizontalGradient(listOf(Color(0xFFB4B3B3),Color(0xFF3E3E3E)))
        Image(painter = painterResource(id = R.drawable.image), contentDescription = null)
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Log in",
            color = Color.White,
            fontSize = 40.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        TextField(
            value = input,
            onValueChange = { input = it },
            placeholder = { Text(text = "Email", color = Color.White, fontWeight = FontWeight.Bold) },
            colors = TextFieldDefaults.colors(focusedContainerColor = Color.Transparent, unfocusedContainerColor = Color.Transparent),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(brush = gradient)

        )
        TextField(
            value = input2,
            onValueChange = { input2 = it },
            placeholder = { Text(text = "Password", color = Color.White, fontWeight = FontWeight.Bold) },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.Transparent, focusedContainerColor = Color.Transparent),
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }, modifier = Modifier.size(30.dp)) {
                    val currentIcon = if(showPassword) R.drawable.hide else R.drawable.visible
                    Icon(
                        painter = painterResource(id = currentIcon),
                        contentDescription = "ShowPassword"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(brush = gradient)
        )

        Text(
            text = "Forgot your password?",
            color = Color(237,237,237),
            modifier = Modifier
                .clickable {}
                .padding(bottom = 20.dp)
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF09A2E)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Log in", color = Color(237,237,237), fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 4.dp))
        }
        Spacer(modifier = Modifier.height(60.dp))
        ElevatedButton(
            onClick = {},
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Log in with Google", fontSize = 15.sp, modifier = Modifier
                .weight(0.9f)
                .padding(vertical = 8.dp))
            Image(painter = painterResource(id = R.drawable.google), contentDescription = null, modifier = Modifier.size(25.dp))
        }
        ElevatedButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Log in with Apple", fontSize = 15.sp, modifier = Modifier
                .weight(0.9f)
                .padding(vertical = 8.dp))
            Image(painter = painterResource(id = R.drawable.apple), contentDescription = null, modifier = Modifier.size(25.dp))
        }
        Spacer(modifier = Modifier.height(70.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Don't have an account?", color = Color.White, modifier = Modifier.padding(end = 8.dp))
            Text(text = "Sign up", color = Color(0xFFFC9614))
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UI_Day1Theme {
        MainScreen()
    }
}