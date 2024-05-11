package com.salty.apps.clipy.presentation.screens.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.salty.apps.clipy.domain.model.Video
import com.salty.apps.clipy.presentation.composable.ImageNetworkLoader

@Composable
fun VideoPlayerBox(video: Video) {
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd,
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            ImageNetworkLoader(
                imageUrl = video.thumbnailUrl, modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
        VideoDuration(video.duration)
    }
}