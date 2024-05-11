package com.salty.apps.clipy.presentation.navigation

sealed class ScreenRoutes(val route: String) {
    data object Home : ScreenRoutes(route = "home")
    data object Detail : ScreenRoutes(route = "detail")
}