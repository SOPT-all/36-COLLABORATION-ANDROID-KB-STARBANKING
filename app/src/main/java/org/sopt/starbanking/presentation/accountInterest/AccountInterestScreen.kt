package org.sopt.starbanking.presentation.accountInterest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.starbanking.R
import org.sopt.starbanking.core.components.CustomThinDivider
import org.sopt.starbanking.core.components.CustomTopBar
import org.sopt.starbanking.core.components.TopBarAction
import org.sopt.starbanking.core.components.TopBarState
import org.sopt.starbanking.presentation.accountInterest.components.AccountInterestTable
import org.sopt.starbanking.presentation.accountInterest.components.AccountInterestTitle
import org.sopt.starbanking.presentation.accountInterest.components.AccountSummary
import org.sopt.starbanking.presentation.accountInterest.components.AccountTermInfo
import org.sopt.starbanking.presentation.accountInterest.components.NoticeBulletList
import org.sopt.starbanking.presentation.accountInterest.components.PreferentialInterestCard
import org.sopt.starbanking.presentation.accountInterest.viewmodel.AccountInterestUiModel
import org.sopt.starbanking.presentation.accountInterest.viewmodel.AccountInterestViewModel
import org.sopt.starbanking.ui.theme.defaultStarBankingColors
import org.sopt.starbanking.ui.theme.defaultkbStarBankingTypography

@Composable
fun AccountInterestRoute(
    padding: PaddingValues,
    navigateToAccountDetail: () -> Unit,
    viewModel: AccountInterestViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getAccountInterest()
    }

    val accountInterest = viewModel.uiState.value


    if (accountInterest == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "로딩 중...")
        }
    } else {
        AccountInterestScreen(
            padding,
            navigateToAccountDetail,
            accountInterest
        )
    }
}

@Composable
private fun AccountInterestScreen(
    padding: PaddingValues,
    navigateToAccountDetail: () -> Unit,
    accountInterest: AccountInterestUiModel?,
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
                savingAccountName = accountInterest?.savingAccountName ?: "",
                accountNumber = accountInterest?.accountNumber ?: ""
            )
            Spacer(modifier.height(20.dp))
            CustomThinDivider()
            AccountTermInfo(
                contractPeriod = accountInterest?.contractPeriod ?: 0,
                startDate = accountInterest?.startDate ?: "",
                endDate = accountInterest?.endDate ?: ""
            )
            CustomThinDivider()
            Spacer(modifier.height(46.dp))
            AccountInterestTitle(title = "기본이율")
            Spacer(modifier.height(5.dp))
            Text(
                text = "(연이율, 세전, 단위: %)",
                style = defaultkbStarBankingTypography.caption1_L
            )
            Spacer(modifier.height(6.dp))
            AccountInterestTable(
                startDate = accountInterest?.startDate,
                endDate = accountInterest?.endDate,
                baseRate = accountInterest?.baseRate
            )
            Spacer(modifier.height(46.dp))
            AccountInterestTitle(title = "우대이율")
            LazyRow(
                modifier = modifier.padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                itemsIndexed(accountInterest!!.preferentialRates) { index, rate ->
                    PreferentialInterestCard(
                        imgIndex = index,
                        savingAccountName = accountInterest.savingAccountName,
                        name = rate.name,
                        rate = rate.rate,
                        startDate =  rate.startDate,
                        endDate = rate.endDate,
                    )
                }
            }
            Spacer(modifier.height(10.dp))
            NoticeBulletList(notice = "이율정보는 조회시점 현재를 기준으로 조회된\n" + "내용이며 만기 시에 최종 확정됩니다.")
            Spacer(modifier.height(7.dp))
            NoticeBulletList(notice = "중도 해지할 경우 중도해지이율이 적용되므로\n" + "유의하시기 바랍니다.")
            Spacer(modifier.height(7.dp))
        }
    }
}