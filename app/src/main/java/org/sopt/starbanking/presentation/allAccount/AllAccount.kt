package org.sopt.starbanking.presentation.allAccount

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
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
import org.sopt.starbanking.presentation.allAccount.components.AccountData
import org.sopt.starbanking.presentation.allAccount.components.BusinessAccountShortcut
import org.sopt.starbanking.presentation.allAccount.components.HomeTabMenu
import org.sopt.starbanking.presentation.allAccount.components.SimpleAccordionItem
import org.sopt.starbanking.ui.theme.StarBankingTheme

@Composable
fun AllAccountsRoute(
    padding: PaddingValues
) {
    AllAccountsScreen(
        padding = padding
    )
}

@Composable
private fun AllAccountsScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues())
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
            val depositAccounts = listOf(
                AccountData("KB맑은하늘적금", "512601-01-250726", "2025.04.23", "2025.10.23", "10,000원"),
                AccountData("KB내맘대로적금", "512601-01-250726", "2025.04.23", "2025.10.23", "10,000원")
            )

            SimpleAccordionItem(
                title = "예금 · 적금",
                isExpanded = true,
                onToggle = { /* toggle 상태 처리 */ },
                accounts = depositAccounts
            )

            SimpleAccordionItem(
                title = "대출",
                isExpanded = false,
                onToggle = {  },
                accounts = depositAccounts
            )

            SimpleAccordionItem(
                title = "보험 · 공제",
                isExpanded = false,
                onToggle = {  },
                accounts = depositAccounts
            )

            SimpleAccordionItem(
                title = "퇴직연금",
                isExpanded = false,
                onToggle = {  },
                accounts = depositAccounts
            )
        }
        Spacer(Modifier.height(23.dp))
        BusinessAccountShortcut({})
    }
}

@Preview
@Composable
fun ShowHomeScreen(){
    AllAccountsScreen(
        padding = PaddingValues(0.dp)
    )
}