package com.salty.apps.clipy.data.repository

import com.salty.apps.clipy.data.State
import com.salty.apps.clipy.data.source.network.VideoDto
import com.salty.apps.clipy.domain.model.Video
import com.salty.apps.clipy.domain.repository.Repository
import com.salty.apps.clipy.utils.DataMapper
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val supabaseClient: SupabaseClient,
) : Repository {
    override suspend fun fetchVideos(): Flow<State<List<Video>>> = flow {
        emit(State.Loading)
        try {
            val response = supabaseClient.postgrest.from("video").select().decodeList<VideoDto>()
            val video = DataMapper.mapDtoToVideoList(response)

            emit(State.Success(video))
        } catch (e: Exception) {
            emit(State.Error(e.message ?: "An error occurred"))
        }
    }
}