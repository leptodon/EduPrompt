package ru.cactus.eduprompt.data.entities

data class Result(
    val end_time: String,
    val lesson_id: String,
    val media: Media,
    val name: String,
    val org: String,
    val short_description: String,
    val start_time: String
)