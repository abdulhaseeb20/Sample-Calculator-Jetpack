package com.example.calculatorsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
                    Greeting("Android")
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorSampleTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun BackgroundTheme() {
    Column(

    ) {
        Row (
        ) {
            // AC +/- % /
            CalculatorButton(text = "AC")
            CalculatorButton(text = "+/-")
            CalculatorButton(text = "%")
        }
        Row {
            // 7 8 9 X
        }
        Row {
            // 4 5 6 -
        }
        Row {
            // 1 2 3 +
        }
        Row {
            // * 0 . =
        }
    }
}

@Composable
fun CalculatorButton(text: String) {
    Button(
        onClick = { /*TODO*/ },
        shape = CircleShape,
        modifier = Modifier
            .width(14.dp)
            .height(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(0.dp),

    )
    {
        Text(
            text = text,
            fontSize = 5.sp
        )
    }
}