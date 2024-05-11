package com.salty.apps.clipy.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.salty.apps.clipy.domain.model.Video
import com.salty.apps.clipy.presentation.viewmodels.shared.SharedViewModel

@Composable
fun VideoList(
    videos: List<Video>,
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
    focusManager: FocusManager,
    lazyListState: LazyListState
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(15.dp), state = lazyListState
    ) {
        items(videos.size) { index ->
            val video = videos[index]
            VideoItem(video, navController, sharedViewModel, focusManager)
        }
    }
}