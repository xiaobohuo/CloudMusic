package com.dom.cloudmusic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dom.cloudmusic.ui.theme.CloudMusicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CloudMusicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    MyButton("Compose 按钮", 20)
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

@Composable
fun MyButton(name: String, padding: Int) {
    Button(onClick = {
        Log.e("====", "Compose 按钮")
    }, modifier = Modifier.fillMaxWidth(0.9f)) {
        Text(text = name)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CloudMusicTheme {
        Greeting("Android")
    }
}