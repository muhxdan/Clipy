package com.salty.apps.clipy.presentation.screens.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.salty.apps.clipy.domain.model.Video
import com.salty.apps.clipy.utils.Utils

@Composable
fun VideoInfo(dataVideo: Video) {
    Column(modifier = Modifier.padding(vertical = 10.dp)) {
        Text(
            text = dataVideo.title,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${Utils.convertToKorM(dataVideo.views)} views • ${
                    Utils.convertToDate(
                        dataVideo.uploadDate
                    )
                }",
                style = MaterialTheme.typography.bodySmall, color = Color.Gray,
            )
            LikeDislikeSection(dataVideo)
        }
    }
}