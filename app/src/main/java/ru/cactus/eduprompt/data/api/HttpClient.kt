package ru.cactus.eduprompt.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://raw.githubusercontent.com/leptodon/mockApi/main/"

private const val MAX_CONNECTION_TIMEOUT = 30L
private const val MAX_READ_TIMEOUT = 30L
private const val MAX_WRITE_TIMEOUT = 30L

class HttpClient {

    fun <S> createService(serviceClass: Class<S>, baseUrl: String = BASE_URL) : S {
        val retrofit = createRetrofitInstance(httpClient, baseUrl)
        return retrofit.create(serviceClass)
    }

    private val httpClient by lazy { createHttpClientInstance() }

    private fun createHttpClientInstance() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(MAX_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(MAX_READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(MAX_WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    private fun createRetrofitInstance(client: OkHttpClient, url: String) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addCallAdapterFactory(createRxConverterFactory())
            .addConverterFactory(createConverterFactory())
            .build()
    }

    private fun createConverterFactory() : Converter.Factory {
        return GsonConverterFactory.create()
    }

    private fun createRxConverterFactory() = RxJava2CallAdapterFactory.create()

}
