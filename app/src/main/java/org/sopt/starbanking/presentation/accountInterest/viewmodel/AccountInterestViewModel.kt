package org.sopt.starbanking.presentation.accountInterest.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.starbanking.data.service.StarBankingService
import javax.inject.Inject

data class AccountInterestUiModel(
    val savingAccountName: String,
    val accountNumber: String,
    val contractPeriod: Int,
    val startDate: String,
    val endDate: String,
    val baseRate: String,
    val baseEndDate: String,
    val preferentialRates: List<PreferentialRateUiModel>
)

data class PreferentialRateUiModel(
    val id: Int,
    val name: String,
    val rate: String,
    val startDate: String,
    val endDate: String
)

@HiltViewModel
class AccountInterestViewModel @Inject constructor(
    private val starBankingService: StarBankingService
) : ViewModel() {

    private val _uiState = mutableStateOf<AccountInterestUiModel?>(null)
    val uiState: State<AccountInterestUiModel?> = _uiState

    fun getAccountInterest(accountID: Long = 1) {
        viewModelScope.launch {
            runCatching {
                starBankingService.getAccountInterest(accountID)
            }.onSuccess { response ->
                val data = response.data
                if (data != null) {
                    _uiState.value = AccountInterestUiModel(
                        savingAccountName = data.savingAccountName,
                        accountNumber = data.accountNumber,
                        contractPeriod = data.contractPeriod,
                        startDate = data.startDate,
                        endDate = data.endDate,
                        baseRate = data.baseRate,
                        baseEndDate = data.baseEndDate,
                        preferentialRates = data.preferentialRates.map { rate ->
                            PreferentialRateUiModel(
                                id = rate.id,
                                name = rate.name,
                                rate = rate.rate,
                                startDate = rate.startDate.takeLast(5),
                                endDate = rate.endDate.takeLast(5)
                            )
                        }
                    )
                }
            }.onFailure {
                // TODO: 에러 처리 로직
            }
        }
    }
}