package org.sopt.starbanking.presentation.accountDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.R
import org.sopt.starbanking.core.components.CustomTopBar
import org.sopt.starbanking.core.components.TopBarAction
import org.sopt.starbanking.core.components.TopBarState
import org.sopt.starbanking.presentation.accountDetail.components.AccountDetailInfoWrapper
import org.sopt.starbanking.ui.theme.defaultStarBankingColors

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
        modifier = modifier
            .fillMaxSize()
            .padding(padding)
            .background(defaultStarBankingColors.white)
    ) {
        CustomTopBar(topBarState)
        Spacer(Modifier.height(18.dp))
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 23.dp)
        ) {
            AccountDetailInfoWrapper()
        }
    }
}

@Preview
@Composable
private fun PreviewThisScreen() {
    AccountDetailScreen(
        padding = PaddingValues(10.dp),
        navigateToAccountInterest = {},
        navigateToTransactionHistory = {},
    )
}