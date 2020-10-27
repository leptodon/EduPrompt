package ru.cactus.eduprompt.data.repository

import io.reactivex.Single
import ru.cactus.eduprompt.data.entities.LessonsList

interface NetworkRepository {
    fun getLessons(): Single<LessonsList>
}