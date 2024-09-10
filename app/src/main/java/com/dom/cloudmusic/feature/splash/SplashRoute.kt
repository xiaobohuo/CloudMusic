package com.dom.cloudmusic.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dom.cloudmusic.R
import com.dom.cloudmusic.core.design.theme.CloudMusicTheme
import com.dom.cloudmusic.util.SuperDateUtil

@Composable
fun SplashRoute() {
    SplashScreen(
        year = SuperDateUtil.currentYear()
    )
}

@Composable
fun SplashScreen(year: Int = 2024) {
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
    }
}

@Preview(showBackground = true)
@Composable
fun SplashRoutePreview() {
    CloudMusicTheme {
        SplashScreen(2024)
    }
}