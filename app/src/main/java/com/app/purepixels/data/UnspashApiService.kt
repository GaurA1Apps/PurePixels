package com.app.purepixels.data

import com.app.purepixels.data.remote.dto.UnsplashImageDto
import com.app.purepixels.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers

interface UnspashApiService {

    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/photos")
    suspend fun getAllImages(): List<UnsplashImageDto>
}