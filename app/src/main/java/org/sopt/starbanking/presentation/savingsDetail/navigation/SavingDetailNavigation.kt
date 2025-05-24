package org.sopt.starbanking.presentation.savingsDetail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.starbanking.core.navigation.Route
import org.sopt.starbanking.presentation.savingsDetail.SavingsDetailScreen

fun NavController.navigateToAccountDetail() {
    navigate(Route.AccountDetail)
}

fun NavGraphBuilder.savingDetailNavGraph(
    padding: PaddingValues,
    navigateToAccountDetail: () -> Unit
) {
    composable<Route.AllAccounts> {
        SavingsDetailScreen(
            navigateToAccountDetail
        )
    }
}