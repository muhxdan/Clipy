package com.salty.apps.clipy.presentation.screens.detail.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.media3.exoplayer.ExoPlayer
import com.salty.apps.clipy.domain.model.Video

@Composable
fun DetailContent(paddingValues: PaddingValues, dataVideo: Video?, exoPlayer: ExoPlayer) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)
    ) {
        item {
            VideoPlayerView(exoPlayer)
            if (dataVideo != null) {
                VideoInfo(dataVideo)
                UserSection(dataVideo)
                DescriptionText(dataVideo.description)
            }
        }
    }
}