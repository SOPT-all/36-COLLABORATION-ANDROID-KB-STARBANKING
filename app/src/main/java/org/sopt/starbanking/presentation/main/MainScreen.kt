package org.sopt.starbanking.presentation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection


@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator()
) {
    MainScreenContent(
        navigator = navigator,
    )
}

@Composable
private fun MainScreenContent(
    navigator: MainNavigator,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        content = { padding ->
            MainNavHost(
                navigator = navigator,
                padding = PaddingValues(
                    start = padding.calculateStartPadding(layoutDirection = LayoutDirection.Ltr),
                    end = padding.calculateEndPadding(layoutDirection = LayoutDirection.Ltr),
                    bottom = padding.calculateBottomPadding(),
                    top = padding.calculateTopPadding()
                )
            )
        },
    )

}