package org.sopt.starbanking.presentation.savingsDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch
import org.sopt.starbanking.data.dto.response.ResponseSavingsState
import org.sopt.starbanking.data.service.StarBankingService
import timber.log.Timber

@HiltViewModel
class SavingsDetailViewModel @Inject constructor(
    private val starBankingService: StarBankingService
) : ViewModel() {

    private val _savingsState = mutableStateOf<ResponseSavingsState?>(null)
    val savingsState: State<ResponseSavingsState?> = _savingsState

    fun fetchSavingsDetail(accountId: Long) {
        Timber.tag("SavingsViewModel").d("🔍 fetchSavingsDetail called with accountId: $accountId")

        viewModelScope.launch {
            runCatching {
                starBankingService.getSavingsState(accountId)
            }.onSuccess { response ->
                Timber.tag("SavingsViewModel").d("✅ API call success: $response")

                val data = response.data
                if (data != null) {
                    _savingsState.value = data
                    Timber.tag("SavingsViewModel").d("Savings data received: $data")
                } else {
                    Timber.tag("SavingsViewModel").w("Response data is null: ${response.message}")
                }

            }.onFailure { throwable ->
                Timber.tag("SavingsViewModel").e(throwable, "API call failed")
            }
        }
    }
}
