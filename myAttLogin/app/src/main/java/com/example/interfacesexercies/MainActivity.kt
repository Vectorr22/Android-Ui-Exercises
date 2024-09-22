package com.example.interfacesexercies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.interfacesexercies.ui.theme.InterfacesExerciesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfacesExerciesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AttInterface()
                }
            }
        }
    }
}


@Composable
fun AttInterface(modifier: Modifier = Modifier) {
    val seePassWord by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomEnd = 32.dp))
            .background(brush = Brush.verticalGradient(colors = listOf(Color.Blue, Color.Cyan)))
            .fillMaxWidth()
            .fillMaxHeight(0.3F),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row {
            Text(
                text = "mi",
                color = Color.White,
                fontStyle = FontStyle.Italic,
                fontSize = 28.sp,
                modifier = Modifier
                    .padding(end = 8.dp, bottom = 3.dp)
                    .align(Alignment.Bottom)
            )
            Text(
                text = "AT&T",
                color = Color.White,
                fontSize = 38.sp,
                modifier = Modifier
                    .align(Alignment.Bottom)
            )
        }
    }
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 32.dp))
            .background(Color.White)
            .fillMaxWidth()
            .fillMaxHeight(1F)
            .padding(20.dp)
    ) {
        Text(
            text = "Iniciar sesion",
            fontSize = 28.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.Transparent),
            placeholder = {
                Text(text = "Número AT&T (10 dígitos)")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = null
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        TextField(
            value = "",
            onValueChange = {},
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.Transparent),
            placeholder = {
                Text(text = "Contraseña")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Lock,
                    contentDescription = null
                )
            },
            trailingIcon = {
                IconButton(onClick = {!seePassWord})
                {
                    val painter = if(seePassWord) R.drawable.invisible else R.drawable.visible
                    Icon(
                        painter = painterResource(id = painter),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            modifier = Modifier.padding(start = 20.dp)
        )

        Row(
            modifier = Modifier.padding(start = 20.dp, top = 8.dp)
        ) {
            Checkbox(
                checked = true,
                onCheckedChange = {},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Gray
                )
            )
            Text(
                text = "Recordar contraseña",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        TextButton(onClick = {}) {
            Text(
                text = "Recuperar contraseña",
                color = Color.Red,
                fontWeight = FontWeight.W700,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier
                .fillMaxWidth(0.8F)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Ingresar")
        }

        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "No tienes cuenta?",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            TextButton(
                onClick = {}
            ) {
                Text(
                    text = "Registrate",
                    color = Color.Red,
                    fontWeight = FontWeight.W700,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun InterfacePreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AttInterface()
    }
}