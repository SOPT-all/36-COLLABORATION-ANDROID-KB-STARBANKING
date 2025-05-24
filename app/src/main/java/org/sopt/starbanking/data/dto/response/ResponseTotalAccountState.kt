package org.sopt.starbanking.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTotalAccountState (
    @SerialName("totalAccountBalance")
    val totalAccountBalance: Int,
    @SerialName("accounts")
    val accounts: List<AccountDto>
)

@Serializable
data class AccountDto(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("accountNumber")
    val accountNumber: String,
    @SerialName("startDate")
    val startDate: String,
    @SerialName("endDate")
    val endDate: String,
    @SerialName("dDay")
    val dDay: String,
    @SerialName("accountBalance")
    val accountBalance: Int
)