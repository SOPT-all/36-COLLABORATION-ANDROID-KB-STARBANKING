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
import org.sopt.starbanking.core.extension.noRippleClickable
import org.sopt.starbanking.presentation.accountDetail.type.AccountDetailCardType

@Composable
fun AccountDetailTitleCard(
    title: String,
    cardType: AccountDetailCardType,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(vertical = cardType.verticalPadding.dp)
            .fillMaxWidth()
            .noRippleClickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = cardType.textStyle
        )
        cardType.iconResId?.let { resId ->
            Icon(
                imageVector = ImageVector.vectorResource(resId),
                contentDescription = cardType.iconDescription,
                tint = Color.Unspecified,
            )
        }
    }
}