package org.sopt.starbanking.presentation.accountInterest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
            .background(defaultStarBankingColors.white)
    ) {
        CustomTopBar(topBarState)
    }
}