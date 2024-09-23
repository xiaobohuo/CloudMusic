package com.dom.cloudmusic.feature.main

import com.dom.cloudmusic.R
import com.dom.cloudmusic.feature.discovery.DISCOVERY_ROUTE
import com.dom.cloudmusic.feature.feed.FEED_ROUTE
import com.dom.cloudmusic.feature.me.ME_ROUTE
import com.dom.cloudmusic.feature.shortvideo.SHORT_VIDEO_ROUTE

enum class TopLevelDestination(
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val titleTextId: Int,
    val route: String,
) {
    DISCOVERY(
        selectedIcon = R.drawable.tab_mall_main_selected,
        unselectedIcon = R.drawable.tab_mall_main,
        titleTextId = R.string.home,
        route = DISCOVERY_ROUTE,
    ),
    SHORT_VIDEO(
        selectedIcon = R.drawable.tab_mall_video_selected,
        unselectedIcon = R.drawable.tab_mall_video,
        titleTextId = R.string.video,
        route = SHORT_VIDEO_ROUTE,
    ),
    ME(
        selectedIcon = R.drawable.tab_mall_me_selected,
        unselectedIcon = R.drawable.tab_mall_me,
        titleTextId = R.string.me,
        route = ME_ROUTE,
    ),
    FEED(
        selectedIcon = R.drawable.tab_mall_cart_selected,
        unselectedIcon = R.drawable.tab_mall_cart,
        titleTextId = R.string.feed,
        route = FEED_ROUTE,
    ),
}