package org.sopt.starbanking.presentation.accountDetail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.starbanking.data.service.StarBankingService
import javax.inject.Inject

data class AccountDetailUiModel(
    val depositCount: Int,
    val accountState: String,
    val lastTransaction: String,
    val contractPeriod: Int
)

@HiltViewModel
class AccountDetailViewModel @Inject constructor(
    private val starBankingService: StarBankingService
) : ViewModel() {

    private val _uiState = mutableStateOf<AccountDetailUiModel?>(null)
    val uiState: State<AccountDetailUiModel?> = _uiState

    fun getAccountDetail(accountID: Long = 1) {
        viewModelScope.launch {
            runCatching {
                starBankingService.getAccountState(accountID)
            }.onSuccess { response ->
                val data = response.data
                if (data != null) {
                    _uiState.value = AccountDetailUiModel(
                        depositCount = data.depositCount,
                        accountState = data.accountState,
                        lastTransaction = data.lastTransaction,
                        contractPeriod = data.contractPeriod
                    )
                }
            }.onFailure {
                // TODO: 에러 처리 로직
            }
        }
    }
}