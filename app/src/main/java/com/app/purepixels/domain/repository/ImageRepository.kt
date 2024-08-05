package com.app.purepixels.domain.repository

import com.app.purepixels.domain.UnsplashImage

interface ImageRepository {

    suspend fun getImages(): List<UnsplashImage>

}