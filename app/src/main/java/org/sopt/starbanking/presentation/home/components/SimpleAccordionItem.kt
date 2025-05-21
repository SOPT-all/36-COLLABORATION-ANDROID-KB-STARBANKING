package org.sopt.starbanking.presentation.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.ui.theme.StarBankingTheme

@Composable
fun SimpleAccordionItem(
    title: String,
    isExpanded: Boolean,
    onToggle: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(StarBankingTheme.colors.white)
            .padding(start = 30.dp)
    ) {
        Row(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp)
                )
                .background(StarBankingTheme.colors.gray3)
                .fillMaxWidth()
                .height(if (isExpanded) 51.dp else 44.dp )
                .padding(start = 26.dp, end = 20.dp)
                .clickable(onClick = onToggle),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, modifier = Modifier.weight(1f))
            Icon(
                imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(11.dp))

        AnimatedVisibility(visible = isExpanded) {
            content()
        }
    }
}

@Composable
@Preview
fun ShowSimpleAccordionItem(){
    SimpleAccordionItem(
        title = "예금, 적금",
        isExpanded = true,
        onToggle = {},
        content = {
            AccountCard(
                title = "KB맑은하늘적금",
                accountNumber = "512601-01-250726",
                startDate = "2025.04.23",
                endDate = "2025.10.23",
                balance = "10,000원",
                onClick = {}
            )
        },
    )
}