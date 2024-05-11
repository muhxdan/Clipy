package com.salty.apps.clipy.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.salty.apps.clipy.presentation.screens.detail.DetailScreen
import com.salty.apps.clipy.presentation.screens.home.HomeScreen
import com.salty.apps.clipy.presentation.viewmodels.shared.SharedViewModel

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.Home.route,
    ) {
        composable(
            route = ScreenRoutes.Home.route,
            exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(300)
                )
            },
            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, tween(300)
                )
            },
            content = {
                HomeScreen(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            },
        )
        composable(
            route = ScreenRoutes.Detail.route,
            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, tween(300)
                )
            },
            exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, tween(300)
                )
            },
            content = {
                DetailScreen(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            },
        )
    }
}