package org.sopt.starbanking.presentation.accountInterest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.ui.theme.defaultStarBankingColors
import org.sopt.starbanking.ui.theme.defaultkbStarBankingTypography

@Composable
fun AccountSummary(
    savingAccountName: String,
    accountNumber: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(defaultStarBankingColors.white)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(3.dp)
                .height(40.dp)
                .background(defaultStarBankingColors.blue3)
        )

        Spacer(modifier = Modifier.width(17.dp))

        Column {
            Text(
                text = savingAccountName,
                style = defaultkbStarBankingTypography.body2_L
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = accountNumber,
                style = defaultkbStarBankingTypography.title2_B
            )
        }
    }
}

@Preview
@Composable
private fun PreviewAccountSummary() {
    AccountSummary(
        savingAccountName = "KB내맘대로적금",
        accountNumber = "293203-02-313912"
    )
}