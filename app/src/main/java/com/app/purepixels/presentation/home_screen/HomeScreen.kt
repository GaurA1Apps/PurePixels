package com.app.purepixels.presentation.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.purepixels.domain.UnsplashImage
import com.app.purepixels.presentation.components.CustomTopAppBar
import com.app.purepixels.presentation.components.ImagesVerticalGrid
import com.app.purepixels.presentation.components.ZoomedImageCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    onSearchClick: () -> Unit,
    onFABClick: () -> Unit,
    onImageClick: (String) -> Unit,
    images: List<UnsplashImage>
) {

    var showImagePreview by remember { mutableStateOf(false) }

    var activeImage by remember { mutableStateOf<UnsplashImage?>(null) }
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTopAppBar(
                scrollBehavior = scrollBehavior,
                onSearchClick = onSearchClick
            )
            ImagesVerticalGrid(images = images,
                onImageClick = onImageClick,
                onImageDragStart = { image ->
                    activeImage = image
                    showImagePreview = true
                },
                onImageDragEnd = {
                    showImagePreview = false
                }
            )
        }
        FloatingActionButton(
            onClick = onFABClick,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(horizontal = 36.dp, vertical = 50.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = Color.Red,
                contentDescription = ""
            )
        }
        ZoomedImageCard(
            modifier = Modifier.padding(24.dp),
            isVisible = showImagePreview, image = activeImage
        )
    }


}