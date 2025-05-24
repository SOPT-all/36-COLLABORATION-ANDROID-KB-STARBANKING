package org.sopt.starbanking.presentation.allAcounts.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.starbanking.core.navigation.Route
import org.sopt.starbanking.presentation.allAcounts.AllAccountsRoute
import org.sopt.starbanking.presentation.home.HomeRoute

fun NavController.navigateToAllAccounts(navOptions: NavOptions) {
    navigate(Route.AllAccounts, navOptions)
}

fun NavGraphBuilder.allAccountsNavGraph(
    padding: PaddingValues,
) {
    composable<Route.AllAccounts> {
        AllAccountsRoute(
            padding = padding,
        )
    }
}