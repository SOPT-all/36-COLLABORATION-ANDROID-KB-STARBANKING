package org.sopt.starbanking.presentation.accountDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.R
import org.sopt.starbanking.ui.theme.defaultkbStarBankingTypography
import org.sopt.starbanking.ui.theme.kbStarBankingFontBold

@Composable
fun AccountDetailTitleItem(
    title: String,
    verticalPadding: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = verticalPadding.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = defaultkbStarBankingTypography.title2_B
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_down),
            contentDescription = "test",
            tint = Color.Unspecified,
        )
    }
}