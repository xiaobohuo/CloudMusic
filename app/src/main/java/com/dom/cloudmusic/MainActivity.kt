package com.dom.cloudmusic

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.dom.cloudmusic.core.design.theme.CloudMusicTheme
import com.dom.cloudmusic.ui.MyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT))
        setContent {
            val naviController = rememberNavController()
            CloudMusicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    MyApp(naviController = naviController)
//                    SplashRoute()
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
fun MyButton(name: Int, padding: Int) {
    Button(onClick = {
        Log.e("====", "Compose 按钮")
    }, modifier = Modifier.fillMaxWidth(0.9f),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Text(text = stringResource(name))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CloudMusicTheme {
        Greeting("Android")
    }
}