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
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.starbanking.R
import org.sopt.starbanking.core.components.CustomHorizontalDivider
import org.sopt.starbanking.core.components.CustomTopBar
import org.sopt.starbanking.core.components.TopBarAction
import org.sopt.starbanking.core.components.TopBarState
import org.sopt.starbanking.presentation.accountDetail.components.AccountDetailDivider
import org.sopt.starbanking.presentation.accountDetail.components.AccountDetailMainInfo
import org.sopt.starbanking.presentation.accountDetail.components.AccountDetailTitleCard
import org.sopt.starbanking.presentation.accountDetail.type.AccountDetailCardType.BOLD
import org.sopt.starbanking.presentation.accountDetail.type.AccountDetailCardType.BOLD_WITH_ICON
import org.sopt.starbanking.presentation.accountDetail.type.AccountDetailCardType.LIGHT_WITH_ICON
import org.sopt.starbanking.presentation.accountDetail.viewmodel.AccountDetailUiModel
import org.sopt.starbanking.presentation.accountDetail.viewmodel.AccountDetailViewModel
import org.sopt.starbanking.ui.theme.defaultStarBankingColors

@Composable
fun AccountDetailRoute(
    padding: PaddingValues,
    navigateToTransactionHistory: () -> Unit,
    navigateToAccountInterest: () -> Unit,
    viewModel: AccountDetailViewModel = hiltViewModel()
) {
    val accountInfo: AccountDetailUiModel = viewModel.uiState.value
    AccountDetailScreen(
        padding = padding,
        navigateToTransactionHistory,
        navigateToAccountInterest,
        accountInfo,
    )
}

@Composable
private fun AccountDetailScreen(
    padding: PaddingValues,
    navigateToTransactionHistory: () -> Unit,
    navigateToAccountInterest: () -> Unit,
    accountInfo: AccountDetailUiModel,
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
            AccountDetailMainInfo(
                accountInfo
            )
            Spacer(Modifier.height(18.dp))
            AccountDetailDivider()
            Spacer(Modifier.height(24.dp))
            AccountDetailTitleCard(
                title = "과세정보",
                cardType = BOLD_WITH_ICON,
            )
            AccountDetailDivider()
            AccountDetailTitleCard(
                title = "대출정보 목록",
                cardType = BOLD_WITH_ICON,
            )
            AccountDetailDivider()
            Spacer(Modifier.height(30.dp))
        }
        CustomHorizontalDivider()
        Spacer(Modifier.height(30.dp))
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 23.dp)
        ) {
            AccountDetailTitleCard(
                title = "관리하기",
                cardType = BOLD,
            )
            AccountDetailTitleCard(
                title = "상품안내",
                cardType = LIGHT_WITH_ICON,
            )
            AccountDetailDivider()
            AccountDetailTitleCard(
                title = "계좌이율 보기",
                cardType = LIGHT_WITH_ICON,
                onClick = navigateToAccountInterest
            )
            AccountDetailDivider()
            AccountDetailTitleCard(
                title = "자동이체 등록",
                cardType = LIGHT_WITH_ICON,
            )
            AccountDetailDivider()
            AccountDetailTitleCard(
                title = "상품만기 알림서비스 신청/해지",
                cardType = LIGHT_WITH_ICON,
            )
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
        accountInfo = AccountDetailUiModel(
            depositCount = 1,
            accountState = "정상",
            lastTransaction = "2025.05.01",
            contractPeriod = 6
        )
    )
}