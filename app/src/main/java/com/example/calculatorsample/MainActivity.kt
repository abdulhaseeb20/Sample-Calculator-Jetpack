package com.example.calculatorsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorsample.ui.theme.CalculatorSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BackgroundTheme()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, wallpaper = Wallpapers.NONE)
@Composable
fun GreetingPreview() {
    CalculatorSampleTheme {
        BackgroundTheme()
    }
}

@Preview(showBackground = true)
@Composable
fun BackgroundTheme() {
    val orange = Color(0xFFFF9800)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 15.dp),
    ) {
        //Centered Text field
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp), // adjust value as needed
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(230.dp)) // move field lower from top
            // call text field in column here
            InputTextField()
        }

        //Calculator buttons
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // AC +/- % /
                CalculatorButton(text = "AC", containerColor = Color.Gray)
                CalculatorButton(text = "+/-", containerColor = Color.Gray)
                CalculatorButton(text = "%", containerColor = Color.Gray)
                CalculatorButton(text = "/", containerColor = orange)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // 7 8 9 X
                CalculatorButton(text = "7", containerColor = Color.DarkGray)
                CalculatorButton(text = "8", containerColor = Color.DarkGray)
                CalculatorButton(text = "9", containerColor = Color.DarkGray)
                CalculatorButton(text = "X", containerColor = orange)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // 4 5 6 -
                CalculatorButton(text = "4", containerColor = Color.DarkGray)
                CalculatorButton(text = "5", containerColor = Color.DarkGray)
                CalculatorButton(text = "6", containerColor = Color.DarkGray)
                CalculatorButton(text = "-", containerColor = orange)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // 1 2 3 +
                CalculatorButton(text = "1", containerColor = Color.DarkGray)
                CalculatorButton(text = "2", containerColor = Color.DarkGray)
                CalculatorButton(text = "3", containerColor = Color.DarkGray)
                CalculatorButton(text = "+", containerColor = orange)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // * 0 . =
                CalculatorButton(text = "^", containerColor = Color.DarkGray)
                CalculatorButton(text = "0", containerColor = Color.DarkGray)
                CalculatorButton(text = ".", containerColor = Color.DarkGray)
                CalculatorButton(text = "=", containerColor = orange)
            }
        }
    }

}

@Composable
fun CalculatorButton(text: String, containerColor: Color) {
    Button(
        onClick = { /*TODO*/ },
        shape = CircleShape,
        modifier = Modifier
            .padding(2.dp)
            .width(64.dp)
            .height(64.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(0.dp),
    )
    {
        Text(
            text = text,
            fontSize = 20.sp
        )
    }
}

@Composable
fun InputTextField() {
    var state = remember { mutableStateOf("") }

    TextField(
        modifier = Modifier.padding(28.dp),
        value = state.value,
        onValueChange = { state.value = it },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
        )
    )
}