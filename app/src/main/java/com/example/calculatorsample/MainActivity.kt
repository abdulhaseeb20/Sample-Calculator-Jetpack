package com.example.calculatorsample

import android.os.Bundle
import android.util.Log
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.objecthunter.exp4j.ExpressionBuilder
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
    val inputState = remember { mutableStateOf("") }    //share state
    val firstNumber = remember { mutableStateOf<Int?>(null) }
    val secondNumber = remember { mutableStateOf<Int?>(null) }
    val operator = remember { mutableStateOf<String?>(null) }
    val result = remember { mutableStateOf<String?>(null) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 15.dp),
    ) {
        //Centered Text field
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(230.dp)) // move field lower from top
            // call text field in column here
            InputTextField(state = inputState)
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
                CalculatorButton(text = "AC", containerColor = Color.Gray, onClick = {
                    inputState.value = ""
                })
                CalculatorButton(text = "+/-", containerColor = Color.Gray, onClick = {

                })
                CalculatorButton(text = "%", containerColor = Color.Gray, onClick = {
//                    firstNumber.value = inputState.value.toInt()
                    operator.value = "%"
                })
                CalculatorButton(text = "/", containerColor = orange, onClick = {
//                    firstNumber.value = inputState.value.toInt()
                    operator.value = "/"
                    inputState.value += "/"
                })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // 7 8 9 X
                CalculatorButton(text = "7", containerColor = Color.DarkGray, onClick = {
                    if (inputState.value.isEmpty())
                    {
//                        firstNumber.value = 7
                        inputState.value = "7"
                    }
                    else
                    {
                        inputState.value += "7"
//                        firstNumber.value = 7
                    }
                })
                CalculatorButton(text = "8", containerColor = Color.DarkGray, onClick = {
                    if (inputState.value.isEmpty())
                    {
                        firstNumber.value = 8
                        inputState.value = "8"
                    }
                    else
                    {
                        firstNumber.value = 8
                        inputState.value += "8"
                    }
                })
                CalculatorButton(text = "9", containerColor = Color.DarkGray, onClick = {
                    if (inputState.value.isEmpty())
                    {
                        firstNumber.value = 9
                        inputState.value = "9"
                    }
                    else
                    {
                        firstNumber.value = 9
                        inputState.value += "9"
                    }
                })
                CalculatorButton(text = "X", containerColor = orange, onClick = {
                    try {
                        firstNumber.value = inputState.value.toInt()
                        operator.value = "X"
                        inputState.value += "X"
                    } catch (e: Exception) {
                        inputState.value = "Error"
                    }
                })

            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // 4 5 6 -
                CalculatorButton(text = "4", containerColor = Color.DarkGray, onClick = {
                    if (inputState.value.isEmpty())
                    {
//                        firstNumber.value = 4
//                        inputState.value = "4"
                        // ****     DEBUG HERE      *****

                        if (operator.value?.isEmpty() == true)
                        {
                            firstNumber.value = 4
//                            Log.DEBUG
                        }
                        else
                        {
                            secondNumber.value = 4
                        }
                        inputState.value += "4"
                    }

                })
                CalculatorButton(text = "5", containerColor = Color.DarkGray, onClick = {
                    if (inputState.value.isEmpty())
                    {
//                        firstNumber.value = 5
//                        inputState.value = "5"

                        if (operator.value?.isEmpty() == true)
                        {
                            firstNumber.value = 5
//                            Log.DEBUG
                        }
                        else
                        {
                            secondNumber.value = 5
                        }
                        inputState.value += "5"
                    }

                })
                CalculatorButton(text = "6", containerColor = Color.DarkGray, onClick = {
                    if (inputState.value.isEmpty())
                    {
//                        firstNumber.value = 6
//                        inputState.value = "6"

                        if (operator.value?.isEmpty() == true)
                        {
                            firstNumber.value = 6
//                            Log.DEBUG
                        }
                        else
                        {
                            secondNumber.value = 6
                        }
                        inputState.value += "6"
                    }

                })
                CalculatorButton(text = "-", containerColor = orange, onClick = {
//                    firstNumber.value = inputState.value.toInt()
                    operator.value = "-"
                    inputState.value += "-"
                })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // 1 2 3 +
                CalculatorButton(text = "1", containerColor = Color.DarkGray, onClick = {
                    if (inputState.value.isEmpty())
                    {
                        firstNumber.value = 1
                        inputState.value += "1"

                        if (operator.value?.isEmpty() == true)
                        {
                            firstNumber.value = 6
//                            Log.DEBUG
                        }
                        else
                        {
                            secondNumber.value = 6
                        }
                        inputState.value += "6"
                    }
                    else
                    {
                        firstNumber.value = inputState.value.toInt()
                    }
                })
                CalculatorButton(text = "2", containerColor = Color.DarkGray, onClick = {
                    if (inputState.value.isEmpty())
                    {
                        firstNumber.value = 2
                        inputState.value += "2"
                    }
                    else
                    {
                        firstNumber.value = inputState.value.toInt()
                    }
                })
                CalculatorButton(text = "3", containerColor = Color.DarkGray, onClick = {
                    if (inputState.value.isEmpty())
                    {
                        firstNumber.value = 3
                        inputState.value += "3"
                    }
                    else
                    {
                        firstNumber.value = inputState.value.toInt()
                    }
                })
                CalculatorButton(text = "+", containerColor = orange, onClick = {
//                    firstNumber.value = inputState.value.toInt()
                    operator.value = "+"
                    inputState.value += "+"
                })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // * 0 . =
                CalculatorButton(text = "^", containerColor = Color.DarkGray, onClick = {
                    inputState.value += "^"
                    operator.value = "^"
                })
                CalculatorButton(text = "0", containerColor = Color.DarkGray, onClick = {
                    if (inputState.value.isEmpty())
                    {
                        firstNumber.value = 0
                        inputState.value += "0"
                    }
                    else
                    {
                        firstNumber.value = inputState.value.toInt()
                    }
                })
                CalculatorButton(text = ".", containerColor = Color.DarkGray, onClick = {
//                    firstNumber.value = inputState.value.toInt()
                    operator.value = "."
                    inputState.value += "."
                })
                CalculatorButton(text = "=", containerColor = orange, onClick = {
                    try {
                        secondNumber.value = inputState.value.toInt()
                        Log.d("value", "Second Number: ${secondNumber.value}")

                        val res = when (operator.value) {
                            "%" -> firstNumber.value!! * (secondNumber.value!!.toFloat() / 100)
                            "X" -> (firstNumber.value!! * secondNumber.value!!).toFloat()
                            "+" -> (firstNumber.value!! + secondNumber.value!!).toFloat()
                            "-" -> (firstNumber.value!! - secondNumber.value!!).toFloat()
                            "/" -> {
                                if (secondNumber.value == 0) throw ArithmeticException("Divide by zero")
                                (firstNumber.value!! / secondNumber.value!!).toFloat()
                            }
                            else -> 0f
                        }

                        result.value = res.toString()
//                        inputState.value = ""
                        operator.value = null
                        firstNumber.value = null
                        secondNumber.value = null
                    } catch (e: Exception) {
                        inputState.value = "Error"
                        Log.e("Calculator", "Error in calculation", e)
                    }
                })

            }
        }
    }
}

@Composable
fun CalculatorButton(text: String, containerColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
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
fun InputTextField(state:MutableState<String>) {
    TextField(
        modifier = Modifier.padding(28.dp),
        value = state.value,
        readOnly = true,
        textStyle = TextStyle(fontSize = 30.sp),
        onValueChange = { state.value = it },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
        ),
    )

}

/*fun evaluateExpression(expression: String): String {
    return try {
        val cleanExpr = expression.replace("×", "*").replace("÷", "/")
        val result = ExpressionBuilder(cleanExpr).build().evaluate()
        result.toString()
    } catch (e: Exception) {
        "Error"
    }
}*/

