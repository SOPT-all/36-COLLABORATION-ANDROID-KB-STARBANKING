package org.sopt.starbanking.presentation.allAccount.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.R
import org.sopt.starbanking.ui.theme.StarBankingTheme

@Composable
fun BusinessAccountShortcut(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.ic_won),
            contentDescription = "원",
            modifier = Modifier.size(23.dp)
        )

        Spacer(modifier = Modifier.width(11.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "사업자계좌 조회 바로가기",
                style = StarBankingTheme.typography.body1_SB
            )
            Text(
                text = "KB스타기업뱅킹",
                style = StarBankingTheme.typography.caption2_L,
                color = StarBankingTheme.colors.gray6
            )
        }

        // 오른쪽 화살표 아이콘
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_android),
            contentDescription = null,
            tint = StarBankingTheme.colors.gray4
        )
    }
}

@Preview
@Composable
fun ShowBusinessAccountShortcut(){
    BusinessAccountShortcut(onClick = {})
}