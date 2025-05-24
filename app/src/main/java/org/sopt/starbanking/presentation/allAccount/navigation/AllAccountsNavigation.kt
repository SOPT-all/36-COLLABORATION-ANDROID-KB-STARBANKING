package org.sopt.starbanking.presentation.allAccount.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.starbanking.core.navigation.Route
import org.sopt.starbanking.presentation.allAccount.AllAccountsRoute

fun NavController.navigateToAllAccounts(navOptions: NavOptions) {
    navigate(Route.AllAccounts, navOptions)
}

fun NavController.navigateToSavingDetail() {
    navigate(Route.SavingDetail)
}

fun NavGraphBuilder.allAccountsNavGraph(
    padding: PaddingValues,
    navigateToSavingDetail: () -> Unit
) {
    composable<Route.AllAccounts> {
        AllAccountsRoute(
            padding = padding,
            navigateToSavingDetail
        )
    }
}