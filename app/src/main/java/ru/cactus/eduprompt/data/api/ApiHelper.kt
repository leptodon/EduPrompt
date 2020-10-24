package ru.cactus.eduprompt.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getLessons() = apiService.getLessons()
}