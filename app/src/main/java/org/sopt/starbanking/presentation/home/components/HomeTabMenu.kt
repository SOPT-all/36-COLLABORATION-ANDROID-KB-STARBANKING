package org.sopt.starbanking.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.starbanking.R
import org.sopt.starbanking.ui.theme.StarBankingTheme

@Composable
fun HomeTabMenu(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ActionButton(
            icon = ImageVector.vectorResource(R.drawable.ic_plus_android),
            text = "다른금융등록",
            onClick = { /* TODO */ }
        )
        Spacer(modifier = Modifier.weight(1f))
        ActionButton(
            icon = ImageVector.vectorResource(R.drawable.ic_card),
            text = "카드형",
            onClick = { /* TODO */ }
        )
        Spacer(modifier = Modifier.width(13.dp))
        ActionButton(
            icon = ImageVector.vectorResource(R.drawable.ic_order_change),
            text = "순서변경",
            onClick = { /* TODO */ }
        )
    }
}

@Composable
fun ActionButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text, style = StarBankingTheme.typography.body3_L)
    }
}

@Preview(showBackground = true)
@Composable
fun ShowHomeTabMenu(){
    HomeTabMenu()
}