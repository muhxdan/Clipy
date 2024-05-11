package com.salty.apps.clipy.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.salty.apps.clipy.utils.Utils

@Composable
fun VideoDuration(duration: Long) {
    Text(
        text = Utils.convertSecondsToMinutes(duration),
        style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
        modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .background(Color.Black.copy(alpha = 0.4f))
            .padding(horizontal = 7.dp, vertical = 4.dp),
    )
}
