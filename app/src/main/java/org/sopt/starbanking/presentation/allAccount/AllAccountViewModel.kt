package org.sopt.starbanking.presentation.allAccount

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.starbanking.data.dto.response.ResponseTotalAccountState
import org.sopt.starbanking.data.service.StarBankingService
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AllAccountViewModel @Inject constructor(
    private val starBankingService: StarBankingService
) : ViewModel() {

    private val _accountState = mutableStateOf<ResponseTotalAccountState?>(null)
    val accountState: State<ResponseTotalAccountState?> = _accountState

    init {
        viewModelScope.launch {
            runCatching {
                starBankingService.getTotalAccountState()
            }.onSuccess { response ->
                Timber.tag("AccountViewModel").d("✅ API call success: $response")

                val data = response.data
                if (data != null) {
                    _accountState.value = data
                    Timber.tag("AccountViewModel").d("Account data received: $data")
                } else {
                    Timber.tag("AccountViewModel").w("Response data is null: ${response.message}")
                }
            }.onFailure { throwable ->
                Timber.tag("AccountViewModel").e(throwable, "API call failed")
            }
        }
    }
}