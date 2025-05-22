package org.sopt.starbanking.presentation.accountDetail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.starbanking.core.navigation.Route
import org.sopt.starbanking.presentation.accountDetail.AccountDetailRoute

fun NavController.navigateToTransactionHistory() {
    navigate(Route.TransactionHistory)
}

fun NavController.navigateToAccountInterest() {
    navigate(Route.AccountInterest)
}

fun NavGraphBuilder.accountDetailGraph(
    navigateToTransactionHistory: () -> Unit,
    navigateToAccountInterest: () -> Unit,
    padding: PaddingValues
) {
    composable<Route.AccountDetail> {
        AccountDetailRoute(
            padding = padding,
            navigateToTransactionHistory,
            navigateToAccountInterest,
        )
    }
}