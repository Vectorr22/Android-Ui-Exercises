package com.vector.ui_day_10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vector.ui_day_10.ui.theme.Purple80
import com.vector.ui_day_10.ui.theme.Ui_day_10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ui_day_10Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MainScreen(paddingValues = innerPadding)
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {
    val email = "test@test.com"
    val color1 = Color(0xFFb453f2)
    val colors = arrayOf(
        0.0F to color1,
        0.55F to Color.Black
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colorStops = colors
                )
            )
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "We've just sent you a 4 number code to $email",
            style = TextStyle(
                color = Color.White,
                fontSize = 12.sp
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Enter your verification code",
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.height(50.dp))
        CustomPasswordField()
        Spacer(modifier = Modifier.height(16.dp))
        val anotadedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontSize = 12.sp
                )
            ) {
                append("Didn't get the code?" + " ")
                pushStringAnnotation(
                    "clickable_text",
                    annotation = "Resend code"
                )
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF251196),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append("Resend code")
                }
            }
        }
        ClickableText(
            text = anotadedString,
            onClick = { offset ->
                anotadedString.getStringAnnotations(
                    tag ="clickable_text",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let {
                    println("texto presionado")
                }
            }
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = color1),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth(0.85f)
        ) {
            Text(
                text = "Confirm",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
        }

    }
}

@Composable
fun CustomPasswordField(
    modifier: Modifier = Modifier,
) {
    var password = remember {
        mutableStateOf("")
    }
    BasicTextField(
        value = password.value,
        onValueChange = { newValue ->
            if (newValue.length <= 4) {
                password.value = newValue
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                val color = Color(0xFFADADAD)
                repeat(times = 4) {
                    val char = when {
                        it >= password.value.length -> ""
                        else -> password.value[it]
                    }
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(
                                if (it == password.value.length) color else Color.White,
                                RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = char.toString(),
                            textAlign = TextAlign.Center,
                            fontSize = 25.sp,
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        },
        modifier = modifier

    )
}

@Preview
@Composable
private fun MainScreenPreview() {
    Ui_day_10Theme {
        MainScreen(paddingValues = PaddingValues(0.dp))
    }
}