package com.app.purepixels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.app.purepixels.navigation.NavGraphSetup
import com.app.purepixels.presentation.home_screen.HomeScreen
import com.app.purepixels.presentation.home_screen.HomeViewModel
import com.app.purepixels.ui.theme.PurePixelsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            PurePixelsTheme {
                val navController = rememberNavController()
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                ) { paddingValues ->
                    NavGraphSetup(scrollBehavior, navHostController = navController)
                }

            }
        }
    }
}
