package com.micpol.norbsoft_recruitment_task.data.model

data class NorbsoftResponse(
    val items: List<Channel> = listOf()
)

data class Channel(
    val snippet: Snippet? = null
)

data class Snippet(
    val title: String = "",
    val description: String = "",
    val channelTitle: String = "",
    val high: Thumbnail
)

data class Thumbnail(
    val url: String = "",
    val width: Float = 0f,
    val height: Float = 0f
)