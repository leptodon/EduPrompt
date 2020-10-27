package ru.cactus.eduprompt.di

import org.koin.dsl.module
import ru.cactus.eduprompt.data.api.ApiService
import ru.cactus.eduprompt.data.api.HttpClient
import ru.cactus.eduprompt.data.repository.NetworkRepository
import ru.cactus.eduprompt.data.repositoryImpl.NetworkRepositoryImpl

object DataModel {

    fun get() = module {
        single { HttpClient() }
        single { get<HttpClient>().createService(ApiService::class.java) }
        single<NetworkRepository> { NetworkRepositoryImpl(get()) }
    }
}