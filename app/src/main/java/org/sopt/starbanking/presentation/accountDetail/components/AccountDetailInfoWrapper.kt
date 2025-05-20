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
import org.sopt.starbanking.ui.theme.defaultkbStarBankingTypography

@Composable
fun AccountDetailInfoWrapper(
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
                text = "1",
                style = defaultkbStarBankingTypography.body1_L
            )
        }
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
                text = "1",
                style = defaultkbStarBankingTypography.body1_L
            )
        }
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
                text = "1",
                style = defaultkbStarBankingTypography.body1_L
            )
        }
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
                text = "1",
                style = defaultkbStarBankingTypography.body1_L
            )
        }
    }
}

@Preview
@Composable
private fun PreviewThis() {
    AccountDetailInfoWrapper()
}