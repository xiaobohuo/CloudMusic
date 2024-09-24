package com.dom.cloudmusic.core.design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dom.cloudmusic.core.design.theme.SpaceSmallHeight
import com.dom.cloudmusic.core.extention.clickableNoRipple
import com.dom.cloudmusic.feature.main.TopLevelDestination

@Composable
fun MyNavigationBar(
    destinations: List<TopLevelDestination>,
    currentDestination: String,
    onNavigateToDestination: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
    ) {
        destinations.forEachIndexed { index, destination ->
            val selected = destination.route == currentDestination
            val color =
                if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickableNoRipple {
                        onNavigateToDestination(index)
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = if (selected) destination.selectedIcon else destination.unselectedIcon),
                    contentDescription = stringResource(id = destination.titleTextId),
                    modifier = Modifier.size(25.dp)
                )
                SpaceSmallHeight()
                Text(
                    text = stringResource(id = destination.titleTextId),
                    style = MaterialTheme.typography.bodySmall,
                    color = color
                )
            }
        }
    }
}