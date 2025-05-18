package org.sopt.starbanking.core.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.core.extension.noRippleClickable
import org.sopt.starbanking.ui.theme.StarBankingTheme

@Composable
fun KBCustomButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.noRippleClickable { onClick() },
        shape = RoundedCornerShape(2.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = StarBankingTheme.colors.gray3,
            contentColor = StarBankingTheme.colors.black
        ),
    ) {
        Text(
            text = text,
            style = StarBankingTheme.typography.body3_L
        )
    }
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
