package org.sopt.starbanking.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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

@Composable
fun CustomTopBar(
    state: TopBarState,
    modifier: Modifier = Modifier,
    height: Dp = 48.dp,
    backgroundColor: Color = StarBankingTheme.colors.white,
    contentColor: Color = StarBankingTheme.colors.black
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = backgroundColor,
        tonalElevation = 0.dp,
        shadowElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .padding(horizontal = 19.dp), // 좌우 패딩 지정
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Navigation 아이콘
            if (state.showNavigationIcon && state.onNavigationClick != null) {
                Icon(
                    imageVector = state.navigationIcon,
                    contentDescription = state.navigationDescription,
                    tint = contentColor,
                    modifier = Modifier.clickable { state.onNavigationClick.invoke() }
                )
            }

            // Title
            Text(
                text = state.title,
                style = StarBankingTheme.typography.title2_L,
                color = contentColor,
                modifier = Modifier
                    .weight(1f)
                    .then(
                        if (state.showNavigationIcon && state.onNavigationClick != null){
                            Modifier.padding(start = 4.dp)  // icon ↔ title 간격
                        } else {
                            Modifier
                        }
                    )
            )

            // Actions
            state.actions.forEachIndexed() { index, action ->
                if (index > 0) Spacer(modifier = Modifier.width(18.dp))
                Icon(
                    imageVector = action.icon,
                    contentDescription = action.contentDescription,
                    tint = contentColor,
                    modifier = Modifier
                        .clickable { action.onClick() }
                )
            }
        }
    }
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
    CustomTopBar(topBarState)
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
    CustomTopBar(topBarState)
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
    CustomTopBar(topBarState)
}