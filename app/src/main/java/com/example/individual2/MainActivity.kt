package com.example.individual2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.individual2.ui.theme.Individual2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Individual2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Row(
                            modifier = Modifier.padding(innerPadding)
                                .background(Color.Cyan)
                        ){
                            ColorCard(color =Color.White,
                                label= "green card",
                                Modifier
                                    .padding(10.dp)
                                    .background(Color.Green)
                                    .border(2.dp, Color.Black)
                                    .size(100.dp)
                            )
                            ColorCard(color =Color.White,
                                label= "red card",
                                Modifier
                                    .background(Color.Red)
                                    .size(100.dp)
                                    .padding(10.dp)
                                    .border(10.dp, Color.White)
                            )
                            ColorCard(color =Color.Black,
                                label= "Yellow card",
                                Modifier
                                    .size(100.dp)
                                    .border(2.dp, Color.Black)
                                    .padding(10.dp)
                                    .background(Color.Yellow)
                            )
                        }
                        ToggleCard()
                        KotlinPracticeScreen()
                    }


                }

            }
        }
    }
}

@Composable
fun ColorCard(color: Color, label: String, modifier: Modifier = Modifier){
    Box (modifier = modifier,
        contentAlignment = Alignment.Center){
        Text(text = label, color = color)
    }
}

@Composable
fun ToggleCard (modifier: Modifier = Modifier){
    //create a variable to track state
    var clicked by rememberSaveable {mutableStateOf(false)}

    //create a variable to keep track of message
    val displayMessage = if (!clicked) "Tap to see a fun fact!" else "Kotlin was created by Jetbrains!"
    Box(modifier = modifier
        .clip(RoundedCornerShape(40.dp))
        .padding(10.dp)
        .size(125.dp)
        .background(Color.LightGray)
        .clickable{clicked = !clicked}, //toggle state when clicked
        contentAlignment = Alignment.Center
    ){
        ColorCard(color=Color.Black, label= displayMessage)
    }
}

@Composable
fun KotlinPracticeScreen(){
    var buttonInput by rememberSaveable { mutableStateOf<String?>( null) }
    var message ="No animal entered" //variable to hold message, default message

    buttonInput?.let{
        message = when(buttonInput){
            "cat" -> "meow meow!"
            "dog" -> "woof woof!"
            "fish" -> "blub blub!"
            else -> "I don't know that animal!"
        }
    }


    Column{
        Row{
            Button(onClick = { buttonInput = null }) {
                Text(text= "null")
            }
            Button(onClick = { buttonInput = "cat" }) {
                Text(text= "cat")
            }
            Button(onClick = { buttonInput = "dog" }) {
                Text(text= "dog")
            }
            Button(onClick = { buttonInput = "fish" }) {
                Text(text= "fish")
            }
            Button(onClick = { buttonInput = "elephant" }) {
                Text(text= "elephant")
            }
        }
        Text(text = message)
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Individual2Theme {
        KotlinPracticeScreen()
    }
}