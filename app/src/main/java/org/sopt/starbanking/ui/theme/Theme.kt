package org.sopt.starbanking.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

private val LightColorScheme = lightColorScheme(
    background = CommonWhite,
    onBackground = CommonBlack,
)

object StarBankingTheme {
    val colors: StarBankingColors
        @Composable
        @ReadOnlyComposable
        get() = LocalStarBankingColorsProvider.current
}

@Composable
fun StarBankingTheme(
    content: @Composable () -> Unit
) {
    val colors = defaultStarBankingColors
    CompositionLocalProvider(
        LocalStarBankingColorsProvider provides colors
    ) {
        MaterialTheme(
            colorScheme = LightColorScheme,
            content = content
        )
    }
}