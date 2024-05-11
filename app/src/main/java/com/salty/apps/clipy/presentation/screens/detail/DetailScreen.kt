package com.salty.apps.clipy.presentation.screens.detail

import android.content.Context
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.NavHostController
import com.salty.apps.clipy.presentation.screens.detail.components.DetailContent
import com.salty.apps.clipy.presentation.screens.detail.components.DetailTopBar
import com.salty.apps.clipy.presentation.viewmodels.shared.SharedViewModel

@Composable
fun DetailScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
    context: Context = LocalContext.current
) {
    val dataVideo by sharedViewModel.dataVideo.collectAsState()
    val exoPlayer = remember { ExoPlayer.Builder(context).build() }

    val mediaItem = dataVideo.data?.videoUrl?.let { MediaItem.fromUri(it) }
    LaunchedEffect(mediaItem) {
        mediaItem?.let {
            exoPlayer.setMediaItem(it)
            exoPlayer.prepare()
            exoPlayer.playWhenReady = true
        }
    }

    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }

    Scaffold(
        topBar = { DetailTopBar(navController) },
        content = { innerPadding ->
            DetailContent(innerPadding, dataVideo.data, exoPlayer)
        },
    )
}