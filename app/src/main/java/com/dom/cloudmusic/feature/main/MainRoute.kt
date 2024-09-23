package com.dom.cloudmusic.feature.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dom.cloudmusic.core.design.component.MyNavigationBar
import com.dom.cloudmusic.feature.discovery.DISCOVERY_ROUTE
import com.dom.cloudmusic.feature.discovery.DiscoveryRoute
import com.dom.cloudmusic.feature.feed.FeedRoute
import com.dom.cloudmusic.feature.me.MeRoute
import com.dom.cloudmusic.feature.shortvideo.ShortVideoRoute

@Composable
fun MainRoute(
    finishPage: () -> Unit
) {
    MainScreen(
        finishPage = finishPage
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    finishPage: () -> Unit
) {
    val pagerState = rememberPagerState {
        4
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            beyondBoundsPageCount = 4,
            userScrollEnabled = false
        ) { page: Int ->
            when (page) {
                0 -> DiscoveryRoute()
                1 -> ShortVideoRoute()
                2 -> MeRoute()
                3 -> FeedRoute()
            }
        }

        MyNavigationBar(
            destinations = TopLevelDestination.entries,
            currentDestination = DISCOVERY_ROUTE,
            onNavigateToDestination = {

            },
            modifier = Modifier,
        )
    }


}