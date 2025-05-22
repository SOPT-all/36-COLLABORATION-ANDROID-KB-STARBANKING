package org.sopt.starbanking.presentation.accountInterest.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.starbanking.core.navigation.Route
import org.sopt.starbanking.presentation.accountInterest.AccountInterestRoute

fun NavController.navigateToAccountDetail() {
    navigate(Route.AccountDetail)
}

fun NavGraphBuilder.accountInterestGraph(
    navigateToAccountDetail: () -> Unit,
    padding: PaddingValues
) {
    composable<Route.AccountInterest> {
        AccountInterestRoute (
            padding = padding,
            navigateToAccountDetail,
        )
    }
}