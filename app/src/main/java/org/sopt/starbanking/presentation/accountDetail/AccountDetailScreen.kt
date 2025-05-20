package org.sopt.starbanking.presentation.accountDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import org.sopt.starbanking.R
import org.sopt.starbanking.core.components.CustomTopBar
import org.sopt.starbanking.core.components.TopBarAction
import org.sopt.starbanking.core.components.TopBarState

@Composable
fun AccountDetailRoute(
    padding: PaddingValues,
    navigateToTransactionHistory: () -> Unit,
    navigateToAccountInterest: () -> Unit,
) {
    AccountDetailScreen(
        padding = padding,
        navigateToTransactionHistory,
        navigateToAccountInterest
    )
}

@Composable
private fun AccountDetailScreen(
    padding: PaddingValues,
    navigateToTransactionHistory: () -> Unit,
    navigateToAccountInterest: () -> Unit,
    modifier: Modifier = Modifier
) {
    val topBarState = TopBarState(
        title = stringResource(R.string.TopBar_View3_title),
        showNavigationIcon = false,
        actions = listOf(
            TopBarAction(
                icon = ImageVector.vectorResource(R.drawable.ic_close),
                contentDescription = stringResource(R.string.ic_close_description),
                onClick = navigateToTransactionHistory
            )
        )
    )
    Column(
        modifier = modifier.padding(padding)
    ) {
        CustomTopBar(
            topBarState
        )
    }
}