package org.sopt.starbanking.presentation.accountInterest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.core.components.CustomThinDivider
import org.sopt.starbanking.ui.theme.defaultStarBankingColors
import org.sopt.starbanking.ui.theme.defaultkbStarBankingTypography

@Composable
fun AccountInterestTable(
    modifier: Modifier = Modifier,
    startDate: String?,
    endDate: String?,
    baseRate: String?
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        CustomThinDivider()
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(defaultStarBankingColors.gray1)
                .height(44.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = modifier
                    .weight(2f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "적용기간",
                    style = defaultkbStarBankingTypography.body3_L,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(defaultStarBankingColors.gr1)
            )
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "기본이율",
                    style = defaultkbStarBankingTypography.body3_L,
                )
            }
        }

        CustomThinDivider()

        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(defaultStarBankingColors.white)
                .height(44.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = modifier.weight(2f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${startDate}~${endDate}",
                    style = defaultkbStarBankingTypography.body3_L,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(defaultStarBankingColors.gr1)
            )
            Box(
                modifier = modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = baseRate?: "",
                    style = defaultkbStarBankingTypography.body3_L,
                )
            }
        }
        CustomThinDivider()
    }
}

@Preview
@Composable
private fun PreviewAccountInterestTable() {
    AccountInterestTable(
        startDate = null,
        endDate = null,
        baseRate = null
    )
}
