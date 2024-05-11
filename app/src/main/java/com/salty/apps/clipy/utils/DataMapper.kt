package com.salty.apps.clipy.utils

import com.salty.apps.clipy.data.source.network.VideoDto
import com.salty.apps.clipy.domain.model.Video


object DataMapper {
    fun mapDtoToVideoList(videoDtoList: List<VideoDto>): List<Video> {
        return videoDtoList.map { dto ->
            Video(
                id = dto.id,
                title = dto.title,
                description = dto.description,
                duration = dto.duration,
                views = dto.views,
                likes = dto.likes,
                dislikes = dto.dislikes,
                uploadDate = dto.uploadDate,
                uploaderName = dto.uploaderName,
                uploaderPhotoUrl = dto.uploaderPhotoUrl,
                thumbnailUrl = dto.thumbnailUrl,
                videoUrl = dto.videoUrl
            )
        }
    }
}