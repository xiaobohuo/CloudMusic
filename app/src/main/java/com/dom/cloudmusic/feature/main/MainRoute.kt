package com.dom.cloudmusic.feature.main

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainRoute(
    finishPage: () -> Unit
) {
    MainScreen(
        finishPage = finishPage
    )
}

@Composable
fun MainScreen(
    finishPage: () -> Unit
) {
    Button(onClick = finishPage, modifier = Modifier.statusBarsPadding()) {
        Text("返回")
    }
}
