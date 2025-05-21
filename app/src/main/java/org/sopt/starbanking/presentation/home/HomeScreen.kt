package org.sopt.starbanking.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.starbanking.R
import org.sopt.starbanking.core.components.CustomTopBar
import org.sopt.starbanking.core.components.TopBarAction
import org.sopt.starbanking.core.components.TopBarState
import org.sopt.starbanking.presentation.home.components.AccountCard
import org.sopt.starbanking.presentation.home.components.BusinessAccountShortcut
import org.sopt.starbanking.presentation.home.components.HomeTabMenu
import org.sopt.starbanking.presentation.home.components.SimpleAccordionItem
import org.sopt.starbanking.ui.theme.StarBankingTheme

@Composable
fun HomeRoute(
    padding: PaddingValues
) {
    HomeScreen(
        padding = padding
    )
}

@Composable
private fun HomeScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(StarBankingTheme.colors.white),
    ) {
        val topBarState = TopBarState(
            title = stringResource(R.string.TopBar_View1_title),
            navigationIcon = ImageVector.vectorResource(R.drawable.ic_arrow_left),
            navigationDescription = stringResource(R.string.ic_arrow_left_description),
            onNavigationClick = { /* 뒤로가기 */ },
            actions = listOf(
                TopBarAction(
                    icon = ImageVector.vectorResource(R.drawable.ic_home),
                    contentDescription = stringResource(R.string.ic_home_description),
                    onClick = { /* 홈 */ }
                ),
                TopBarAction(
                    icon = ImageVector.vectorResource(R.drawable.ic_menu),
                    contentDescription = stringResource(R.string.ic_menu_description),
                    onClick = { /* 설정 또는 검색 */ }
                )
            )
        )
        CustomTopBar(topBarState)
        Spacer(modifier = Modifier.height(18.dp))
        HomeTabMenu()
        Spacer(modifier = Modifier.height(23.dp))

        Column {
            SimpleAccordionItem(
                title = "예금 • 적금",
                isExpanded = true,
                onToggle = {  }
            ) {
                AccountCard(
                    title = "KB맑은하늘적금",
                    accountNumber = "512601-01-250726",
                    startDate = "2025.04.23",
                    endDate = "2025.10.23",
                    balance = "10,000원",
                    onClick = {}
                )
            }

            SimpleAccordionItem(
                title = "대출",
                isExpanded = false,
                onToggle = {  }
            ) {
                Text("대출 정보", modifier = Modifier.padding(16.dp))
            }

            SimpleAccordionItem(
                title = "보험 · 공제",
                isExpanded = false,
                onToggle = {  }
            ) {
                Text("보험 정보", modifier = Modifier.padding(16.dp))
            }

            SimpleAccordionItem(
                title = "퇴직연금",
                isExpanded = false,
                onToggle = {  }
            ) {
                Text("연금 정보", modifier = Modifier.padding(16.dp))
            }
        }
        Spacer(Modifier.height(23.dp))
        BusinessAccountShortcut({})
    }
}

@Preview
@Composable
fun ShowHomeScreen(){
    HomeScreen(
        padding = PaddingValues(0.dp)
    )
}