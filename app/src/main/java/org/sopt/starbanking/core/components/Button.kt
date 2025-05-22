package org.sopt.starbanking.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.core.extension.noRippleClickable
import org.sopt.starbanking.ui.theme.StarBankingTheme


@Composable
fun NoRippleButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(2.dp))
            .background(StarBankingTheme.colors.gray3)
            .noRippleClickable { onClick() }
            .padding(vertical = 10.dp, horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = StarBankingTheme.typography.body3_L,
            color = StarBankingTheme.colors.black
        )
    }
}

@Composable
fun KBCustomButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit
) {
    NoRippleButton(
        modifier = modifier,
        text = text,
        onClick = onClick
    )
}

@Composable
fun KBSmallButton(text: String, onClick: () -> Unit) {
    KBCustomButton(
        modifier = Modifier
            .width(148.dp)
            .height(38.dp),
        text = text,
        onClick = onClick
    )
}

@Composable
fun KBMediumButton(text: String, onClick: () -> Unit) {
    KBCustomButton(
        modifier = Modifier
            .width(156.dp)
            .height(37.dp),
        text = text,
        onClick = onClick
    )
}

@Composable
fun KBLargeButton(text: String, onClick: () -> Unit) {
    KBCustomButton(
        modifier = Modifier
            .width(294.dp)
            .height(37.dp),
        text = text,
        onClick = onClick
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewCustomButton() {
    KBSmallButton(text = "hi", onClick = {})
    KBMediumButton(text = "hi", onClick = {})
    KBLargeButton(text = "hi", onClick = {})
}
