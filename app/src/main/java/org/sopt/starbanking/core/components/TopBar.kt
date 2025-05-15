package org.sopt.starbanking.core.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.starbanking.R
import org.sopt.starbanking.ui.theme.StarBankingTheme

data class TopBarState(
    val title: String = "",
    val showNavigationIcon: Boolean = true,
    val navigationIcon: ImageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
    val navigationDescription: String = "Navigation",
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
                    Icon(imageVector = state.navigationIcon, contentDescription = state.navigationDescription)
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
    TopBar(topBarState)
}

@Preview
@Composable
fun View3(){
    val topBarState = TopBarState(
        title = stringResource(R.string.TopBar_View3_title),
        showNavigationIcon = false,
        actions = listOf(
            TopBarAction(
                icon = ImageVector.vectorResource(R.drawable.ic_close),
                contentDescription = stringResource(R.string.ic_close_description),
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
        title = stringResource(R.string.TopBar_View4_title),
        showNavigationIcon = false,
        actions = listOf(
            TopBarAction(
                icon = ImageVector.vectorResource(R.drawable.ic_close),
                contentDescription = stringResource(R.string.ic_close_description),
                onClick = { /* 닫기 */}
            )
        )
    )
    TopBar(topBarState)
}