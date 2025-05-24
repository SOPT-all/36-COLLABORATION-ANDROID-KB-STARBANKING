package org.sopt.starbanking.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object TransactionHistory : Route

    @Serializable
    data object AccountDetail : Route

    @Serializable
    data object AccountInterest : Route

    @Serializable
    data object AllAccounts: Route

    @Serializable
    data object SavingDetail: Route
}