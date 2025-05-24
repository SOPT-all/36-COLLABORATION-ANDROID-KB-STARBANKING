package org.sopt.starbanking.presentation.accountDetail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class AccountDetailUiModel(
    val depositCount: Int,
    val accountState: String,
    val lastTransaction: String,
    val contractPeriod: Int
)


@HiltViewModel
class AccountDetailViewModel @Inject constructor() : ViewModel() {
    private val _uiState = mutableStateOf<AccountDetailUiModel>(
        AccountDetailUiModel(
            depositCount = 1,
            accountState = "정상",
            lastTransaction = "2025.05.01",
            contractPeriod = 6
        )
    )
    val uiState: State<AccountDetailUiModel> = _uiState

    init {
        _uiState.value = AccountDetailUiModel(
            depositCount = 1,
            accountState = "정상",
            lastTransaction = "2025.05.01",
            contractPeriod = 6
        )
    }
}