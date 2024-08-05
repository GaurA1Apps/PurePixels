package com.app.purepixels.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.memory.MemoryCache
import coil.request.ImageRequest
import com.app.purepixels.domain.UnsplashImage
import com.skydoves.cloudy.Cloudy

@Composable
fun ZoomedImageCard(
    isVisible: Boolean,
    modifier: Modifier = Modifier,
    image: UnsplashImage?
) {

    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(image?.imageUrlRegular)
        .placeholderMemoryCacheKey(MemoryCache.Key(image?.imageUrlSmall ?: ""))
        .crossfade(true)
        .build()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isVisible) {
            Cloudy(
                modifier = Modifier.fillMaxSize(),
                radius = 25
            ) {
            }
        }
        AnimatedVisibility(visible = isVisible,
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut(),
            modifier = Modifier.align(Alignment.Center)
        ) {
            ElevatedCard(
                modifier = modifier
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    AsyncImage(
                        model = image?.photographerProfileImgUrl,
                        modifier = Modifier.size(25.dp)
                            .clip(CircleShape)
                            .padding(16.dp),
                        contentDescription = null
                    )
                    Text(
                        text = image?.photographerName ?: "Anonymous",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                AsyncImage(
                    model = imageRequest,
                    modifier = Modifier.fillMaxWidth(),
                    contentDescription = null
                )
            }
        }
    }

}