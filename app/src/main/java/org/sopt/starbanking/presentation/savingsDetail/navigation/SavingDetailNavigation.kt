package org.sopt.starbanking.presentation.savingsDetail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.starbanking.core.navigation.Route
import org.sopt.starbanking.presentation.savingsDetail.SavingDetailRoute


fun NavGraphBuilder.savingDetailNavGraph(
    padding: PaddingValues,
    navigateToAccountDetail: () -> Unit
) {
    composable<Route.SavingDetail> {
        SavingDetailRoute(
            navigateToAccountDetail
        )
    }
}