package org.sopt.starbanking.presentation.accountInterest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.R
import org.sopt.starbanking.core.components.CustomThinDivider
import org.sopt.starbanking.core.components.CustomTopBar
import org.sopt.starbanking.core.components.TopBarAction
import org.sopt.starbanking.core.components.TopBarState
import org.sopt.starbanking.presentation.accountInterest.components.AccountSummary
import org.sopt.starbanking.presentation.accountInterest.components.AccountTermInfo
import org.sopt.starbanking.ui.theme.defaultStarBankingColors

@Composable
fun AccountInterestRoute(
    padding: PaddingValues,
    navigateToAccountDetail: () -> Unit,
) {
    AccountInterestScreen(
        padding,
        navigateToAccountDetail
    )
}

@Composable
private fun AccountInterestScreen(
    padding: PaddingValues,
    navigateToAccountDetail: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val topBarState = TopBarState(
        title = stringResource(R.string.TopBar_View4_title),
        showNavigationIcon = false,
        actions = listOf(
            TopBarAction(
                icon = ImageVector.vectorResource(R.drawable.ic_close),
                contentDescription = stringResource(R.string.ic_close_description),
                onClick = navigateToAccountDetail
            )
        )
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(padding)
            .verticalScroll(rememberScrollState())
            .background(defaultStarBankingColors.white)
    ) {
        CustomTopBar(topBarState)
        Spacer(modifier.height(13.dp))
        Column(
            modifier.padding(horizontal = 23.dp)
        ) {
            AccountSummary(
                savingAccountName = "KB내맘대로적금",
                accountNumber = "293203-02-313912"
            )
            Spacer(modifier.height(20.dp))
            CustomThinDivider()
            AccountTermInfo(
                contractPeriod = 12,
                startDate = "2025.04.25",
                endDate = "2026.04.25"
            )
        }
    }
}