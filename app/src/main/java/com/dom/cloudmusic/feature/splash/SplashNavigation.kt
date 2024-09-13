package com.dom.cloudmusic.feature.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SPLASH_ROUTE = "Splash"

fun NavGraphBuilder.splashScreen(
    toMain: () -> Unit
) {
    composable(SPLASH_ROUTE) {
        SplashRoute(
            toMain = toMain
        )
    }
}