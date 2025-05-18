package org.sopt.starbanking.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.ui.theme.StarBankingTheme

@Composable
fun CustomHorizontalDivider(
    modifier: Modifier = Modifier,
    backgroundColor: Color = StarBankingTheme.colors.gray1
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(10.dp)
            .background(backgroundColor)
    )
}

@Preview
@Composable
fun PreviewCustomHorizontalDivider() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(StarBankingTheme.colors.white)
            .height(50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        CustomHorizontalDivider()
    }
}