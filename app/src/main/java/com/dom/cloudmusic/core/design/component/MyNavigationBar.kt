package com.dom.cloudmusic.core.design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dom.cloudmusic.core.design.theme.SpaceSmallHeight
import com.dom.cloudmusic.feature.main.TopLevelDestination

@Composable
fun MyNavigationBar(
    destinations: List<TopLevelDestination>,
    currentDestination: String,
    onNavigateToDestination: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        destinations.forEachIndexed { index, destination ->
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = destination.unselectedIcon),
                    contentDescription = stringResource(id = destination.titleTextId),
                    modifier = Modifier.size(25.dp)
                )
                SpaceSmallHeight()
                Text(
                    text = stringResource(id = destination.titleTextId)
                )
            }
        }
    }
}