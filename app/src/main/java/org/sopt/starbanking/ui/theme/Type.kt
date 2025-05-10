package org.sopt.starbanking.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.sopt.starbanking.R

val kbStarBankingFontBold = FontFamily(Font(R.font.pretendard_bold))
val kbStarBankingFontSemiBold = FontFamily(Font(R.font.pretendard_semibold))
val kbStarBankingFontRegular = FontFamily(Font(R.font.pretendard_regular))
val kbStarBankingFontLight = FontFamily(Font(R.font.pretendard_light))
val kbStarBankingFontMedium = FontFamily(Font(R.font.pretendard_medium))

@Immutable
data class kbStarBankingTypography(
    val title1_SB: TextStyle,
    val title1_L: TextStyle,
    val title2_B: TextStyle,
    val title2_SB: TextStyle,
    val title2_L: TextStyle,
    val subTitle1_L: TextStyle,
    val body1_SB: TextStyle,
    val body1_L: TextStyle,
    val body2_SB: TextStyle,
    val body2_R: TextStyle,
    val body2_L: TextStyle,
    val body3_L: TextStyle,
    val body3_M: TextStyle,
    val caption1_L: TextStyle,
    val caption2_L: TextStyle,
    val caption3_M: TextStyle
)

val defaultkbStarBankingTypography = kbStarBankingTypography(
    title1_SB = TextStyle(
        fontFamily = kbStarBankingFontSemiBold,
        fontSize = 24.sp,
        fontWeight = FontWeight(600),
        lineHeight = 20.sp
    ),
    title1_L = TextStyle(
        fontFamily = kbStarBankingFontLight,
        fontSize = 24.sp,
        fontWeight = FontWeight(300),
        lineHeight = 20.sp
    ),
    title2_B = TextStyle(
        fontFamily = kbStarBankingFontBold,
        fontSize = 18.sp,
        fontWeight = FontWeight(700),
        lineHeight = 20.sp
    ),
    title2_SB = TextStyle(
        fontFamily = kbStarBankingFontSemiBold,
        fontSize = 18.sp,
        fontWeight = FontWeight(600),
        lineHeight = 20.sp
    ),
    title2_L = TextStyle(
        fontFamily = kbStarBankingFontLight,
        fontSize = 18.sp,
        fontWeight = FontWeight(300),
        lineHeight = 20.sp
    ),
    subTitle1_L = TextStyle(
        fontFamily = kbStarBankingFontLight,
        fontSize = 18.sp,
        fontWeight = FontWeight(600),
        lineHeight = 24.sp
    ),
    body1_SB = TextStyle(
        fontFamily = kbStarBankingFontSemiBold,
        fontSize = 16.sp,
        fontWeight = FontWeight(600),
        lineHeight = 20.sp
    ),
    body1_L = TextStyle(
        fontFamily = kbStarBankingFontLight,
        fontSize = 16.sp,
        fontWeight = FontWeight(300),
        lineHeight = 22.sp
    ),
    body2_SB = TextStyle(
        fontFamily = kbStarBankingFontSemiBold,
        fontSize = 15.sp,
        fontWeight = FontWeight(600),
        lineHeight = 20.sp
    ),
    body2_R = TextStyle(
        fontFamily = kbStarBankingFontRegular,
        fontSize = 15.sp,
        fontWeight = FontWeight(400),
        lineHeight = 20.sp
    ),
    body2_L = TextStyle(
        fontFamily = kbStarBankingFontLight,
        fontSize = 15.sp,
        fontWeight = FontWeight(300),
        lineHeight = 22.sp
    ),
    body3_L = TextStyle(
        fontFamily = kbStarBankingFontLight,
        fontSize = 14.sp,
        fontWeight = FontWeight(300),
        lineHeight = 20.sp
    ),
    body3_M = TextStyle(
        fontFamily = kbStarBankingFontMedium,
        fontSize = 14.sp,
        fontWeight = FontWeight(500),
        lineHeight = 20.sp
    ),
    caption1_L = TextStyle(
        fontFamily = kbStarBankingFontLight,
        fontSize = 13.sp,
        fontWeight = FontWeight(300),
        lineHeight = 20.sp
    ),
    caption2_L = TextStyle(
        fontFamily = kbStarBankingFontLight,
        fontSize = 12.sp,
        fontWeight = FontWeight(300),
        lineHeight = 12.sp
    ),
    caption3_M = TextStyle(
        fontFamily = kbStarBankingFontMedium,
        fontSize = 11.sp,
        fontWeight = FontWeight(500),
        lineHeight = 11.sp
    )
)

val LocalkbStarBankingTypographyProvider = staticCompositionLocalOf { defaultkbStarBankingTypography }