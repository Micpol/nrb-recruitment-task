package com.micpol.norbsoft_recruitment_task.data.model

data class NorbsoftResponse(
    val items: List<Channel>
)

data class Channel(
    val snippet: Snippet?
)

data class Snippet(
    val title: String,
    val description: String,
    val channelTitle: String,
    val thumbnails: Thumbnails
)

data class Thumbnails(
    val default: Thumbnail,
    val medium: Thumbnail,
    val high: Thumbnail
)

data class Thumbnail(
    val url: String,
    val width: Float = 0f,
    val height: Float = 0f
)