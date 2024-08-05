package com.app.purepixels.di

import com.app.purepixels.data.UnspashApiService
import com.app.purepixels.utils.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object AppModule {

    val contentType = "application/json".toMediaType()
    val json = Json { ignoreUnknownKeys = true }
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory(contentType))
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: UnspashApiService by lazy {
        retrofit.create(UnspashApiService::class.java)
    }
}