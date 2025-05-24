package org.sopt.starbanking.presentation.accountInterest.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.serialization.SerialName
import org.sopt.starbanking.R
import org.sopt.starbanking.core.extension.noRippleClickable
import org.sopt.starbanking.presentation.accountInterest.viewmodel.PreferentialRateUiModel
import org.sopt.starbanking.ui.theme.defaultStarBankingColors
import org.sopt.starbanking.ui.theme.defaultkbStarBankingTypography

@Composable
fun PreferentialInterestCard(
    imgIndex: Int,
    savingAccountName: String?,
    name: String?,
    rate: String?,
    startDate: String?,
    endDate: String?,
    modifier: Modifier = Modifier,
) {
    val imageRes = when (imgIndex) {
        0 -> R.drawable.img_card_1
        1 -> R.drawable.img_card_2
        2 -> R.drawable.img_card_3
        else -> R.drawable.img_card_1
    }
    Column(
        modifier = modifier
            .width(165.dp)
            .background(
                color = defaultStarBankingColors.yellow1,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp)
                .padding(start = 12.dp, end = 12.dp, top = 14.dp, bottom = 4.dp)
        ) {
            Text(
                text = "${savingAccountName}\n${name}",
                style = defaultkbStarBankingTypography.body3_M,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Image(
                painter = painterResource(imageRes),
                contentDescription = "캐릭터",
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.BottomEnd)
            )
        }

        Column(
            modifier = modifier
                .background(defaultStarBankingColors.gray1)
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("우대이율", style = defaultkbStarBankingTypography.caption1_L)
                Text(text = rate ?: "", style = defaultkbStarBankingTypography.caption1_L)
            }

            Spacer(modifier = modifier.height(6.dp))

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("기간", style = defaultkbStarBankingTypography.caption1_L)
                Text("${startDate}~${endDate}", style = defaultkbStarBankingTypography.caption1_L)
            }
            Spacer(modifier = modifier.height(18.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(defaultStarBankingColors.white, RoundedCornerShape(4.dp))
                    .noRippleClickable { }
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("보러가기", style = defaultkbStarBankingTypography.caption1_L)
            }
        }
    }
}

@Preview
@Composable
private fun PreviewPreferentialInterestCard() {
    PreferentialInterestCard(
        imgIndex = 1,
        savingAccountName = "",
        name = "",
        rate = "",
        startDate = "",
        endDate = ""
    )
}