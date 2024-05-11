package com.salty.apps.clipy.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.salty.apps.clipy.domain.model.Video
import com.salty.apps.clipy.utils.Utils

@Composable
fun VideoMetaData(video: Video) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = video.title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(bottom = 3.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "${video.uploaderName} ・ ${Utils.convertToKorM(video.views)} views ・ ${
                Utils.convertToDate(
                    video.uploadDate
                )
            }", style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
        )
    }
}