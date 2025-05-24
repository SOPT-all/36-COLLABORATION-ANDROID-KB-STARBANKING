package org.sopt.starbanking.presentation.accountInterest.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.R
import org.sopt.starbanking.ui.theme.defaultkbStarBankingTypography

@Composable
fun AccountTermInfo(
    contractPeriod: Int,
    startDate: String,
    endDate: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier.padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
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
                text = "${contractPeriod}${stringResource(R.string.month_unit)}",
                style = defaultkbStarBankingTypography.body1_L
            )
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "신규일",
                style = defaultkbStarBankingTypography.body1_L
            )
            Text(
                text = startDate,
                style = defaultkbStarBankingTypography.body1_L
            )
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "만기일",
                style = defaultkbStarBankingTypography.body1_L
            )
            Text(
                text = endDate,
                style = defaultkbStarBankingTypography.body1_L
            )
        }
    }
}


@Preview
@Composable
private fun PreviewAccountTermInfo() {
    AccountTermInfo(
        contractPeriod = 12,
        startDate = "2025.04.25",
        endDate = "2026.04.25"
    )
}