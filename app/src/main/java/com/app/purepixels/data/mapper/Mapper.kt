package com.app.purepixels.data.mapper

import com.app.purepixels.data.remote.dto.UnsplashImageDto
import com.app.purepixels.domain.UnsplashImage

fun UnsplashImageDto.toDomainModel(): UnsplashImage {
    return UnsplashImage(
        id = this.id,
        imageUrlSmall = this.urls.small,
        imageUrlRaw = this.urls.raw,
        imageUrlRegular = this.urls.regular,
        photographerName = this.user.name,
        photographerUsername = this.user.username,
        photographerProfileImgUrl = this.user.profileImage.small,
        photographerProfileLink = this.user.links.html,
        width = this.width,
        height = this.height,
        description = this.description
    )
}

fun List<UnsplashImageDto>.toDomainModelList(): List<UnsplashImage> {
    return this.map { it.toDomainModel() }
}