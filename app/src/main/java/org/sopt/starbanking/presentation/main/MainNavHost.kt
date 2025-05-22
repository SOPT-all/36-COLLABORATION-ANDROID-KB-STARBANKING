package org.sopt.starbanking.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.sopt.starbanking.presentation.accountDetail.navigation.accountDetailGraph
import org.sopt.starbanking.presentation.home.navigation.homeNavGraph

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    padding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination
        ) {
            homeNavGraph(padding = padding)
            accountDetailGraph(
                padding = padding,
                navigateToTransactionHistory = navigator::navigateToTransactionHistory,
                navigateToAccountInterest = navigator::navigateToAccountInterest
            )
        }
    }
}