package com.dom.cloudmusic.feature.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dom.cloudmusic.feature.splash.SPLASH_ROUTE

const val MAIN_ROUTE = "main"

fun NavController.navigateToMain() {
    navigate(MAIN_ROUTE) {
        launchSingleTop = true
        popUpTo(SPLASH_ROUTE) {
            inclusive = true
        }
    }
}

fun NavGraphBuilder.mainScreen(
    finishPage: () -> Unit
) {
    composable(MAIN_ROUTE) {
        MainRoute(
            finishPage = finishPage
        )
    }
}