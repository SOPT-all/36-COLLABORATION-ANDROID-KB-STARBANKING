package org.sopt.starbanking.core.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.starbanking.R
import org.sopt.starbanking.ui.theme.StarBankingTheme

data class TopBarState(
    val title: String = "",
    val showNavigationIcon: Boolean = true,
    val navigationIcon: ImageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
    val onNavigationClick: (() -> Unit)? = null,
    val actions: List<TopBarAction> = emptyList()
)

data class TopBarAction(
    val icon: ImageVector,
    val contentDescription: String,
    val onClick: () -> Unit
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(state: TopBarState) {
    TopAppBar(
        title = {
            Text(text = state.title, style = StarBankingTheme.typography.title2_L)
        },
        navigationIcon = {
            if (state.showNavigationIcon && state.onNavigationClick != null) {
                IconButton(onClick = state.onNavigationClick) {
                    Icon(imageVector = state.navigationIcon, contentDescription = "Navigation")
                }
            }
        },
        actions = {
            state.actions.forEach { action ->
                IconButton(onClick = action.onClick) {
                    Icon(imageVector = action.icon, contentDescription = action.contentDescription)
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = StarBankingTheme.colors.white,
            titleContentColor = StarBankingTheme.colors.black,
            navigationIconContentColor = StarBankingTheme.colors.black
        )
    )
}

@Preview
@Composable
fun View1(){
    val topBarState = TopBarState(
        title = "전체계좌조회",
        navigationIcon = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
        onNavigationClick = { /* 뒤로가기 */ },
        actions = listOf(
            TopBarAction(
                icon = Icons.Default.Home,
                contentDescription = "홈",
                onClick = { /* 홈 */ }
            ),
            TopBarAction(
                icon = Icons.Default.Menu,
                contentDescription = "메뉴",
                onClick = { /* 설정 또는 검색 */ }
            )
        )
    )
    TopBar(topBarState)
}

@Preview
@Composable
fun View3(){
    val topBarState = TopBarState(
        title = "계좌상세정보",
        showNavigationIcon = false,
        actions = listOf(
            TopBarAction(
                icon = Icons.Default.Close,
                contentDescription = "닫기",
                onClick = { /* 닫기 */ }
            )
        )
    )
    TopBar(topBarState)
}

@Preview
@Composable
fun View4(){
    val topBarState = TopBarState(
        title = "계좌이율 보기",
        showNavigationIcon = false,
        navigationIcon = Icons.Default.Close,
        actions = listOf(
            TopBarAction(
                icon = Icons.Default.Close,
                contentDescription = "닫기",
                onClick = { /* 닫기 */}
            )
        )
    )
    TopBar(topBarState)
}