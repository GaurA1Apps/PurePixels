package com.app.purepixels.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.app.purepixels.domain.UnsplashImage

@Composable
fun HomeImageCard(
    modifier: Modifier,
    image: UnsplashImage?,
    onImageClick: (String) -> Unit
) {

    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(image?.imageUrlSmall)
        .crossfade(true)
        .build()

    val aspectRatio by remember {
        derivedStateOf { (image?.width?.toFloat() ?: 1f) / (image?.height?.toFloat() ?: 1f) }
    }

    ElevatedCard(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(aspectRatio),
        onClick = {
            onImageClick(image?.id ?: "")
        }

    ) {
        AsyncImage(
            model = imageRequest, contentDescription = "UnsplashImage",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        FavoriteButton(
            isFavorite = true,
            onClick = { },
            modifier = Modifier.align(Alignment.End)
        )
    }

}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onClick: () -> Unit
) {
    FilledIconToggleButton(
        modifier = modifier,
        checked = isFavorite,
        onCheckedChange = { onClick() },
        colors = IconButtonDefaults.filledIconToggleButtonColors(
            containerColor = Color.Transparent
        )
    ) {
        if (isFavorite) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
        } else {
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
        }
    }
}