package com.app.purepixels.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.app.purepixels.presentation.fav_screen.FavScreen
import com.app.purepixels.presentation.full_image_screen.FullImageScreen
import com.app.purepixels.presentation.home_screen.HomeScreen
import com.app.purepixels.presentation.home_screen.HomeViewModel
import com.app.purepixels.presentation.search_screen.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraphSetup(
    scrollBehavior: TopAppBarScrollBehavior,
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = Routes.HomeScreen) {
        composable<Routes.HomeScreen> {
            val homeViewModel = viewModel<HomeViewModel>()
            HomeScreen(modifier = Modifier
                .fillMaxSize(),
                scrollBehavior = scrollBehavior,
                images = homeViewModel.images,
                onSearchClick = {
                    navHostController.navigate(Routes.SearchScreen)
                },
                onFABClick = {
                    navHostController.navigate(Routes.FavScreen)
                },
                onImageClick ={ imageId ->
                    navHostController.navigate(Routes.FullImageScreen(imageId))
                })

        }


        composable<Routes.SearchScreen> {
            SearchScreen {
                navHostController.navigateUp()
            }
        }
        composable<Routes.FavScreen> {
            FavScreen {
                navHostController.navigateUp()
            }
        }

        composable<Routes.FullImageScreen> { backStacKentry ->
            val imageId = backStacKentry.toRoute<Routes.FullImageScreen>().imageiD
            FullImageScreen(imageId = imageId) {
                navHostController.navigateUp()
            }
        }
    }
}