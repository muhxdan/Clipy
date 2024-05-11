package com.salty.apps.clipy.domain.model

data class Video(
    val id: Long,
    val title: String,
    val description: String,
    val duration: Long,
    val views: Long,
    val likes: Long,
    val dislikes: Long,
    val uploadDate: String,
    val uploaderName: String,
    val uploaderPhotoUrl: String,
    val thumbnailUrl: String,
    val videoUrl: String
)