package com.dom.cloudmusic.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dom.cloudmusic.feature.main.mainScreen
import com.dom.cloudmusic.feature.main.navigateToMain
import com.dom.cloudmusic.feature.splash.splashScreen

@Composable
fun MyApp(naviController: NavHostController) {
    NavHost(navController = naviController, startDestination = "splash") {
        splashScreen(naviController::navigateToMain)
        mainScreen(
            finishPage = naviController::popBackStack
        )
    }
}