package org.sopt.starbanking.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.starbanking.core.navigation.Route
import org.sopt.starbanking.presentation.allAccount.navigation.navigateToAllAccounts
import org.sopt.starbanking.presentation.accountDetail.navigation.navigateToAccountInterest
import org.sopt.starbanking.presentation.accountDetail.navigation.navigateToTransactionHistory
import org.sopt.starbanking.presentation.accountInterest.navigation.navigateToAccountDetail
import org.sopt.starbanking.presentation.home.navigation.navigateToHome


class MainNavigator(
    val navController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination
    val startDestination = Route.Home

    fun navigateToHome(navOptions: NavOptions? = null) {
        navController.navigateToHome(
            navOptions ?: navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        )
    }

    fun navigateToAllAccounts(navOptions: NavOptions? = null) {
        navController.navigateToAllAccounts(
            navOptions ?: navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        )
    }
    fun navigateToTransactionHistory() {
        navController.navigateToTransactionHistory()
    }

    fun navigateToAccountInterest() {
        navController.navigateToAccountInterest()
    }

    fun navigateToAccountDetail() {
        navController.navigateToAccountDetail()
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}