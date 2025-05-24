package org.sopt.starbanking.presentation.allAccount.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.R
import org.sopt.starbanking.core.components.KBLargeButton
import org.sopt.starbanking.core.extension.noRippleClickable
import org.sopt.starbanking.ui.theme.StarBankingTheme

@Composable
fun AccountCard(
    title: String,
    accountNumber: String,
    startDate: String,
    endDate: String,
    balance: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(330.dp)
            .height(285.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = StarBankingTheme.colors.white,
            disabledContentColor = StarBankingTheme.colors.white
        ),
        shape = RoundedCornerShape(4.dp)
    ) {
        Box (
            modifier = Modifier
                .fillMaxSize()
        ) {
            Icon(
                ImageVector.vectorResource(R.drawable.ic_menu_vert_android),
                contentDescription = "메뉴",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
                    .noRippleClickable {
                        onClick()
                    }
            )

            Column(
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .align(Alignment.CenterStart),
                verticalArrangement = Arrangement.Center
            ) {
                Text(title, style = StarBankingTheme.typography.body1_L)
                Spacer(Modifier.height(4.dp))
                Text(accountNumber, style = StarBankingTheme.typography.body2_SB)

                Spacer(Modifier.height(12.dp))
                Text("신규일: $startDate")
                Text("만기일: $endDate")

                Spacer(Modifier.height(12.dp))
                OutlinedButton(
                    onClick = {  },
                    colors = ButtonDefaults.outlinedButtonColors(),
                    modifier = Modifier
                        .height(30.dp)
                        .width(67.dp),
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "전용화면",
                        style = StarBankingTheme.typography.caption2_L,
                        color = StarBankingTheme.colors.black
                    )
                }

                Spacer(Modifier.height(15.dp))
                Text(
                    text = balance,
                    style = StarBankingTheme.typography.title2_SB,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
                Spacer(Modifier.height(16.dp))
                KBLargeButton(
                    text = "입금",
                    onClick = { }
                )
            }
        }
    }
}

@Composable
@Preview
fun ShowAccountCard(){
    AccountCard(
        title = "KB맑은하늘적금",
        accountNumber = "512601-01-250726",
        startDate = "2025.04.23",
        endDate = "2025.10.23",
        balance = "10,000원",
        onClick = {}
    )
}