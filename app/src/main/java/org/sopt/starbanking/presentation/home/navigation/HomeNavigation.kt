package org.sopt.starbanking.presentation.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.starbanking.core.navigation.Route
import org.sopt.starbanking.presentation.home.HomeRoute

fun NavController.navigateToHome(navOptions: NavOptions) {
    navigate(Route.Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    padding: PaddingValues,
) {
    composable<Route.Home> {
        HomeRoute(
            padding = padding,
        )
    }
}