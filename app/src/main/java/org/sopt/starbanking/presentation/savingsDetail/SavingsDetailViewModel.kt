package org.sopt.starbanking.presentation.savingsDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

data class Deposit(
    val id: Long,
    val count: Int,
    val depositDate: String,
    val payment: Int,
    val afterPaymentBalance: Int,
    val appliedRate: String
)

data class SavingsDetailUiModel(
    val savingAccountName: String,
    val accountNumber: String,
    val totalBalance: Int,
    val startDate: String,
    val endDate: String,
    val dDay: String,
    val preferentialRate: String,
    val maxAppliedRate: String,
    val deposits: List<Deposit>
)

@HiltViewModel
class SavingsDetailViewModel @Inject constructor() : ViewModel() {

    private val _uiState = mutableStateOf<SavingsDetailUiModel?>(null)
    val uiState: State<SavingsDetailUiModel?> = _uiState

    init {
        // 임시 하드코딩
        _uiState.value = SavingsDetailUiModel(
            savingAccountName = "KB 내맘대로 적금",
            accountNumber = "293203-04-313912",
            totalBalance = 10000,
            startDate = "2025.04.23",
            endDate = "2025.10.23",
            dDay = "D-183",
            preferentialRate = "6.00",
            maxAppliedRate = "8.00",
            deposits = listOf(
                Deposit(
                    id = 1L,
                    count = 1,
                    depositDate = "2025.05.01",
                    payment = 10000,
                    afterPaymentBalance = 10000,
                    appliedRate = "6.00"
                )
            )
        )
    }
}
