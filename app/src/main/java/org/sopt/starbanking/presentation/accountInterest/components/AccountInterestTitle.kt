package org.sopt.starbanking.presentation.accountInterest.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.ui.theme.defaultkbStarBankingTypography


@Composable
fun AccountInterestTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .padding(vertical = 7.dp)
            .fillMaxWidth(),
        text = title,
        style = defaultkbStarBankingTypography.title2_SB
    )
}