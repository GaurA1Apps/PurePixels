package com.app.purepixels.presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.purepixels.data.mapper.toDomainModelList
import com.app.purepixels.di.AppModule
import com.app.purepixels.domain.UnsplashImage
import com.app.purepixels.domain.repository.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: ImageRepository
): ViewModel() {

    var images: List<UnsplashImage> by mutableStateOf(emptyList())
        private set

    init {
        getAllImages()
    }

    private fun getAllImages(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getImages()
            images = result
        }
    }
}