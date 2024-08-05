package com.app.purepixels.data

import com.app.purepixels.data.mapper.toDomainModelList
import com.app.purepixels.domain.UnsplashImage
import com.app.purepixels.domain.repository.ImageRepository

class ImageRepositoryImpl(
    private val api: UnspashApiService
): ImageRepository {

    override suspend fun getImages(): List<UnsplashImage> {
        return api.getAllImages().toDomainModelList()
    }
}