package com.app.purepixels.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {

    @Serializable
    data object HomeScreen : Routes()

    @Serializable
    data object SearchScreen : Routes()

    @Serializable
    data object FavScreen : Routes()

    @Serializable
    data class FullImageScreen(val imageiD: String) : Routes()

    @Serializable
    data class ProfileScreen(val profileLink: String) : Routes()
}