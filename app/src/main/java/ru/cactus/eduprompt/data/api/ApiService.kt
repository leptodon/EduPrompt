package ru.cactus.eduprompt.data.api

import io.reactivex.Single
import retrofit2.http.GET
import ru.cactus.eduprompt.data.entities.LessonsList

interface ApiService {
    @GET("lessons")
    fun getLessons(): Single<LessonsList>
}