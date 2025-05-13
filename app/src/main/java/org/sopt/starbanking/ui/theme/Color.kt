package org.sopt.starbanking.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val CommonBlack = Color(0xFF000000)
val CommonWhite = Color(0xFFFFFFFF)

val MainBlue1 = Color(0xFF287EFF)
val MainBlue2 = Color(0xFFEFF5FB)
val MainBlue3 = Color(0xFF646EB2)
val MainYellow1 = Color(0xFFFFD338)
val MainYellow2 = Color(0xFFFFD338)
val MainYellow3 = Color(0xFFFFBC00)

val Gray1 = Color(0xFFF7F7F8)
val Gray2 = Color(0xFFF1F3F5)
val Gray3 = Color(0xFFEBEEF0)
val Gray4 = Color(0xFFDDE1E4)
val Gray5 = Color(0xFF838B94)
val Gray6 = Color(0xFF696E76)
val Gray7 = Color(0xFF4A4D53)
val Gray8 = Color(0xFF484B51)
val Gray9 = Color(0xFF1C1B1F)

val Gr1 = Color(0x0D000000)
val Gr2 = Color(0x80000000)

@Immutable
data class StarBankingColors(
    val black: Color = CommonBlack,
    val white: Color = CommonWhite,
    val blue1: Color = MainBlue1,
    val blue2: Color = MainBlue2,
    val blue3: Color = MainBlue3,
    val yellow1: Color = MainYellow1,
    val yellow2: Color = MainYellow2,
    val yellow3: Color = MainYellow3,
    val gray1: Color = Gray1,
    val gray2: Color = Gray2,
    val gray3: Color = Gray3,
    val gray4: Color = Gray4,
    val gray5: Color = Gray5,
    val gray6: Color = Gray6,
    val gray7: Color = Gray7,
    val gray8: Color = Gray8,
    val gray9: Color = Gray9,
    val gr1: Color = Gr1,
    val gr2: Color = Gr2,
)

val defaultStarBankingColors = StarBankingColors()

val LocalStarBankingColorsProvider = staticCompositionLocalOf { defaultStarBankingColors }