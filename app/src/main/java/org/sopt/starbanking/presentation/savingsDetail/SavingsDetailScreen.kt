package org.sopt.starbanking.presentation.savingsDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.starbanking.R
import org.sopt.starbanking.core.components.CustomHorizontalDivider
import org.sopt.starbanking.core.components.CustomTopBar
import org.sopt.starbanking.core.components.KBMediumButton
import org.sopt.starbanking.core.components.TopBarAction
import org.sopt.starbanking.core.components.TopBarState
import org.sopt.starbanking.core.extension.noRippleClickable
import org.sopt.starbanking.ui.theme.StarBankingTheme

@Composable
fun SavingsDetailScreen(
    accountId: Long,
    viewModel: SavingsDetailViewModel = hiltViewModel()
) {
    val savingsState = viewModel.savingsState.value

    LaunchedEffect(Unit) {
        viewModel.fetchSavingsDetail(accountId)
    }

    if (savingsState == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "로딩 중...")
        }
        return
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StarBankingTheme.colors.white)
            .statusBarsPadding()
    ) {
        CustomTopBar(
            state = TopBarState(
                title = "전체계좌조회",
                showNavigationIcon = true,
                navigationIcon = ImageVector.vectorResource(id = R.drawable.ic_arrow_left),
                navigationDescription = "뒤로가기",
                onNavigationClick = { /* TODO */ },
                actions = listOf(
                    TopBarAction(
                        icon = ImageVector.vectorResource(id = R.drawable.ic_home),
                        contentDescription = "홈",
                        onClick = { /* TODO */ }
                    ),
                    TopBarAction(
                        icon = ImageVector.vectorResource(id = R.drawable.ic_menu),
                        contentDescription = "메뉴",
                        onClick = { /* TODO */ }
                    )
                )
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.width(320.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = savingsState.savingAccountName,
                            style = StarBankingTheme.typography.body1_L
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_pencil_android),
                            contentDescription = "수정",
                            tint = StarBankingTheme.colors.black
                        )
                    }
                    Text(
                        text = savingsState.accountNumber,
                        style = StarBankingTheme.typography.title2_SB
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_settings_android),
                    contentDescription = "설정",
                    tint = StarBankingTheme.colors.black
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.width(320.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = savingsState.totalBalance.toString(),
                    style = StarBankingTheme.typography.title1_SB
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "원",
                    style = StarBankingTheme.typography.title1_L
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.width(320.dp)) {
                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(21.dp)
                        .background(
                            color = StarBankingTheme.colors.gray8,
                            shape = RoundedCornerShape(11.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = savingsState.dDay,
                        style = StarBankingTheme.typography.caption3_M,
                        color = StarBankingTheme.colors.white
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                ProgressBar(
                    maxExp = 100000,
                    progress = 0.5f
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "신규일 ${savingsState.startDate}",
                        style = StarBankingTheme.typography.caption2_L
                    )
                    Text(
                        "만기일 ${savingsState.endDate}",
                        style = StarBankingTheme.typography.caption2_L
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    KBMediumButton(text = "입금", onClick = { })
                    Spacer(modifier = Modifier.width(8.dp))
                    KBMediumButton(text = "해지예상조회", onClick = { })
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            CustomHorizontalDivider()
            Spacer(modifier = Modifier.height(24.dp))

            val highlightColor = StarBankingTheme.colors.yellow2

            Column(modifier = Modifier.width(320.dp)) {
                Text(
                    text = "현재 적용 중인 우대금리는",
                    style = StarBankingTheme.typography.title2_SB
                )
                Text(
                    text = buildAnnotatedString {
                        append("연 ")

                        withStyle(
                            style = SpanStyle(
                                background = highlightColor,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.Black
                            )
                        ) {
                            append("${savingsState.preferentialRate}%")
                        }

                        append("에요")
                    },
                    style = StarBankingTheme.typography.title2_SB.copy(
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${savingsState.endDate}까지 123,900원 모을 수 있어요.\n해당 상품의 최고 적용금리는 연 ${savingsState.maxAppliedRate}%입니다.",
                    style = StarBankingTheme.typography.body3_L
                )
            }


            Spacer(modifier = Modifier.height(24.dp))
            savingsState.deposits.forEach { deposit ->
                Card(
                    modifier = Modifier
                        .width(320.dp)
                        .height(264.dp),
                    colors = CardDefaults.cardColors(containerColor = StarBankingTheme.colors.gray1),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = StarBankingTheme.colors.gray3)
                                .padding(horizontal = 16.dp, vertical = 10.dp)
                        ) {
                            Row {
                                Text(
                                    text = "${deposit.id}회차",
                                    style = StarBankingTheme.typography.body2_SB,
                                    color = StarBankingTheme.colors.black
                                )
                                Text(
                                    text = "  |  ",
                                    style = StarBankingTheme.typography.body3_M,
                                    color = StarBankingTheme.colors.gray6
                                )
                                Text(
                                    text = "${deposit.depositDate}분",
                                    style = StarBankingTheme.typography.body3_M,
                                    color = StarBankingTheme.colors.gray6
                                )
                            }
                        }

                        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                            DetailRow("납입일자", deposit.depositDate)
                            Spacer(modifier = Modifier.height(14.dp))
                            DetailRow(
                                label = "납입금액",
                                value = "${deposit.payment} 원",
                                valueColor = StarBankingTheme.colors.blue1
                            )
                            Spacer(modifier = Modifier.height(14.dp))
                            DetailRow("납입 후 잔액", "${deposit.afterPaymentBalance} 원")
                            Spacer(modifier = Modifier.height(14.dp))
                            DetailRow("적금방식", "1일 1회 직접 입금")
                            Spacer(modifier = Modifier.height(14.dp))
                            DetailRow("적용금리", "연 ${deposit.appliedRate}%")
                            Spacer(modifier = Modifier.height(14.dp))

                            Spacer(modifier = Modifier.height(12.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(
                                    text = "돈암동",
                                    style = StarBankingTheme.typography.body3_L,
                                    color = StarBankingTheme.colors.gray6
                                )
                                Text(
                                    text = "  |  ",
                                    style = StarBankingTheme.typography.body3_L,
                                    color = StarBankingTheme.colors.gray6
                                )
                                Text(
                                    text = "신규",
                                    style = StarBankingTheme.typography.body3_L,
                                    color = StarBankingTheme.colors.gray6
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Column(modifier = Modifier.width(320.dp)) {
                Text(
                    "*놓치고 있는 금리가 있어요!",
                    style = StarBankingTheme.typography.caption2_L,
                    color = StarBankingTheme.colors.black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Image(
                    painter = painterResource(id = R.drawable.banner_android),
                    contentDescription = "퀴즈 배너",
                    modifier = Modifier
                        .fillMaxWidth()
                        .noRippleClickable { }
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "*최고 적용금리 8.00% = 기본금리 2.50% + 퀴즈 풀이 시 5.50%p",
                    style = StarBankingTheme.typography.caption2_L,
                    color = StarBankingTheme.colors.gray6
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun DetailRow(
    label: String,
    value: String,
    valueColor: Color = StarBankingTheme.colors.black
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, style = StarBankingTheme.typography.body2_L)
        Text(
            text = value,
            style = StarBankingTheme.typography.body2_R,
            color = valueColor
        )
    }
}


@Composable
fun ProgressBar(
    maxExp: Int,
    progress: Float,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = StarBankingTheme.colors.gray1
    val progressColor = StarBankingTheme.colors.yellow2
    val borderColor = StarBankingTheme.colors.gray4

    val currentProgress = progress.coerceIn(0f, 1f)
    val barWidth = 320.dp

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .width(barWidth)
                .height(8.dp)
                .border(1.dp, borderColor, RoundedCornerShape(10.dp))
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(currentProgress)
                    .background(
                        color = progressColor,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
        }

        Spacer(modifier = Modifier.height(4.dp))
    }
}
