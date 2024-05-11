package com.salty.apps.clipy.presentation.screens.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.salty.apps.clipy.R
import com.salty.apps.clipy.domain.model.Video
import com.salty.apps.clipy.utils.Utils

@Composable
fun LikeDislikeSection(dataVideo: Video) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Gray.copy(alpha = 0.3f))
            .padding(10.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_like),
            contentDescription = "Likes",
            modifier = Modifier.padding(end = 5.dp)
        )
        Text(
            text = Utils.convertToKorM(dataVideo.likes), style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_dislike),
            contentDescription = "Dislikes",
            modifier = Modifier.padding(end = 5.dp)
        )
        Text(
            text = Utils.convertToKorM(dataVideo.dislikes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}