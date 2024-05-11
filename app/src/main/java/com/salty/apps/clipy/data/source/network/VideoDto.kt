package com.salty.apps.clipy.data.source.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class VideoDto(
    val id: Long,
    val title: String,
    val description: String,
    val duration: Long,
    val views: Long,
    val likes: Long,
    val dislikes: Long,
    @SerialName("upload_date")
    val uploadDate: String,
    @SerialName("uploader_name")
    val uploaderName: String,
    @SerialName("uploader_photo_url")
    val uploaderPhotoUrl: String,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("video_url")
    val videoUrl: String
)