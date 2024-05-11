package com.salty.apps.clipy.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.salty.apps.clipy.presentation.navigation.AppNavHost
import com.salty.apps.clipy.presentation.theme.ClipyTheme
import com.salty.apps.clipy.presentation.viewmodels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        splashScreen.setKeepOnScreenCondition { splashViewModel.isSplashShow.value }
        setContent {
            ClipyTheme {
                AppNavHost()
            }
        }
    }
}