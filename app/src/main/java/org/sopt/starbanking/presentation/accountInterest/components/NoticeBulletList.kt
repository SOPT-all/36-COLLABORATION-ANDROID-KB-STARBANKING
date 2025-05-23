package org.sopt.starbanking.presentation.accountInterest.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.ui.theme.defaultkbStarBankingTypography

@Composable
fun NoticeBulletList(
    notice: String,
    modifier: Modifier = Modifier
) {
    Column {
        Row {
            Text(
                text = "▪",
                style = defaultkbStarBankingTypography.body3_L,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = notice,
                style = defaultkbStarBankingTypography.body3_L,
            )
        }
    }
}
