package com.salty.apps.clipy.domain.repository

import com.salty.apps.clipy.data.State
import com.salty.apps.clipy.domain.model.Video
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun fetchVideos(): Flow<State<List<Video>>>
}