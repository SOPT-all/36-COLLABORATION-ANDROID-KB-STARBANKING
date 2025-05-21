package org.sopt.starbanking.presentation.accountDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.presentation.accountDetail.viewmodel.AccountDetailUiModel
import org.sopt.starbanking.ui.theme.defaultkbStarBankingTypography

@Composable
fun AccountDetailMainInfo(
    accountInfo: AccountDetailUiModel,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "납입회차",
                style = defaultkbStarBankingTypography.body1_L
            )
            Text(
                text = accountInfo.depositCount.toString(),
                style = defaultkbStarBankingTypography.body1_L
            )
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "계좌상태",
                style = defaultkbStarBankingTypography.body1_L
            )
            Text(
                text = accountInfo.accountState,
                style = defaultkbStarBankingTypography.body1_L
            )
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "최종거래일",
                style = defaultkbStarBankingTypography.body1_L
            )
            Text(
                text = accountInfo.lastTransaction,
                style = defaultkbStarBankingTypography.body1_L
            )
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "계약기간",
                style = defaultkbStarBankingTypography.body1_L
            )
            Text(
                text = accountInfo.contractPeriod.toString(),
                style = defaultkbStarBankingTypography.body1_L
            )
        }
    }
}

@Preview
@Composable
private fun PreviewThis() {
    AccountDetailMainInfo(
        AccountDetailUiModel(
            depositCount = 1,
            accountState = "정상",
            lastTransaction = "2025.05.01",
            contractPeriod = 6
        )
    )
}