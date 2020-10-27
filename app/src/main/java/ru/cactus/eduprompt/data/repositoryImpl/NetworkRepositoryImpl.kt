package ru.cactus.eduprompt.data.repositoryImpl

import io.reactivex.Single
import ru.cactus.eduprompt.data.api.ApiService
import ru.cactus.eduprompt.data.entities.LessonsList
import ru.cactus.eduprompt.data.repository.NetworkRepository

class NetworkRepositoryImpl(private val apiService: ApiService): NetworkRepository {
    override fun getLessons(): Single<LessonsList> {
        return apiService.getLessons()
    }

}