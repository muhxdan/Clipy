package com.salty.apps.clipy.domain.usecase

import com.salty.apps.clipy.data.State
import com.salty.apps.clipy.domain.model.Video
import com.salty.apps.clipy.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: Repository) {
    suspend fun fetchVideos(): Flow<State<List<Video>>> = repository.fetchVideos()
}