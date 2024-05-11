package com.salty.apps.clipy.presentation.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.salty.apps.clipy.domain.model.Video
import com.salty.apps.clipy.presentation.navigation.ScreenRoutes
import com.salty.apps.clipy.presentation.viewmodels.shared.SharedViewModel

@Composable
fun VideoItem(
    video: Video,
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
    focusManager: FocusManager
) {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(12.dp))
            .clickable(onClick = {
                focusManager.clearFocus()
                sharedViewModel
                    .setDataVideo(video)
                    .also {
                        navController.navigate(ScreenRoutes.Detail.route)
                    }
            })
    ) {
        VideoPlayerBox(video)
        VideoInfoRow(video)
    }
}