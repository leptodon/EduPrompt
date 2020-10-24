package ru.cactus.eduprompt.data.api

import retrofit2.http.GET
import ru.cactus.eduprompt.data.model.LessonsList

interface ApiService {
    @GET("lessons")
    suspend fun getLessons(): LessonsList
}