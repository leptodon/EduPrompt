package ru.cactus.eduprompt.data.repository

import ru.cactus.eduprompt.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getLessons() = apiHelper.getLessons()
}