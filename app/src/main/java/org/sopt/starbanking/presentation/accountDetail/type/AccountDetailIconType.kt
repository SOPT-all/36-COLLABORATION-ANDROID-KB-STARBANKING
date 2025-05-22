package org.sopt.starbanking.presentation.accountDetail.type

import androidx.annotation.StringRes
import androidx.compose.ui.text.TextStyle
import org.sopt.starbanking.R
import org.sopt.starbanking.ui.theme.defaultkbStarBankingTypography

enum class AccountDetailCardType(
    @StringRes val iconResId: Int?,
    val textStyle: TextStyle,
    val iconDescription: String,
    val verticalPadding: Int
) {
    BOLD_WITH_ICON(
        iconResId = R.drawable.ic_arrow_down,
        textStyle = defaultkbStarBankingTypography.title2_B,
        iconDescription = "down arrow",
        verticalPadding = 20
    ),
    BOLD(
        iconResId = null,
        textStyle = defaultkbStarBankingTypography.title2_B,
        iconDescription = "",
        verticalPadding = 7
    ),
    LIGHT_WITH_ICON(
        iconResId = R.drawable.ic_arrow_right,
        textStyle = defaultkbStarBankingTypography.body1_L,
        iconDescription = "right arrow",
        verticalPadding = 18
    )
}