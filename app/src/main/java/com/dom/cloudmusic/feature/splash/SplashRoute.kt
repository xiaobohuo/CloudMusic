package com.dom.cloudmusic.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dom.cloudmusic.R
import com.dom.cloudmusic.core.design.theme.CloudMusicTheme
import com.dom.cloudmusic.util.SuperDateUtil

@Composable
fun SplashRoute(
    toMain: () -> Unit,
    viewModel: SplashViewModel = viewModel()
) {
    val timeLeft by viewModel.timeLeft.collectAsStateWithLifecycle()
    val navigateToMain by viewModel.navigateToMain.collectAsStateWithLifecycle()
    SplashScreen(
        year = SuperDateUtil.currentYear(),
        timeLeft = timeLeft,
        onSkipAdClick = viewModel::onSkipAdClick
    )
    if (navigateToMain) {
        LaunchedEffect(key1 = true) {
            toMain()
        }
    }
}

@Composable
fun SplashScreen(
    year: Int = 2024,
    timeLeft: Long = 0,
    onSkipAdClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        //region 头部图片
        Image(
            painter = painterResource(R.drawable.splash_banner),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 150.dp)
                .align(Alignment.TopCenter)
        )
        //endregion

        //region 底部文字
        Image(
            painter = painterResource(R.drawable.splash_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 70.dp)
                .align(Alignment.BottomCenter)
                .clickable {
                    onSkipAdClick()
                }
        )
        //endregion

        //region 底部版权
        Text(
            text = stringResource(R.string.copyright, year),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
        )
        //endregion
        Text(
            text = "倒计时：$timeLeft",
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 30.dp, end = 20.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashRoutePreview() {
    CloudMusicTheme {
        SplashScreen(2024)
    }
}