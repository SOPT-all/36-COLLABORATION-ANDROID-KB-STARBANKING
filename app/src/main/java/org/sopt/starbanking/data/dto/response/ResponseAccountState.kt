package org.sopt.starbanking.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseAccountState(
    @SerialName("depositCount")
    val depositCount: String,
    @SerialName("accountState")
    val accountState: String,
    @SerialName("lastTransaction")
    val lastTransaction: String,
    @SerialName("contractPeriod")
    val contractPeriod: Int
)

@Serializable
data class ResponseSavingsState(
    @SerialName("savingAccountName")
    val savingAccountName: String,
    @SerialName("accountNumber")
    val accountNumber: String,
    @SerialName("totalBalance")
    val totalBalance: Int,
    @SerialName("startDate")
    val startDate: String,
    @SerialName("endDate")
    val endDate: String,
    @SerialName("dDay")
    val dDay: String,
    @SerialName("preferentialRate")
    val preferentialRate: String,
    @SerialName("maxAppliedRate")
    val maxAppliedRate: String,
    @SerialName("deposits")
    val deposits: List<DepositDto>
)

@Serializable
data class DepositDto(
    @SerialName("id")
    val id: Long,
    @SerialName("count")
    val count: Int,
    @SerialName("depositDate")
    val depositDate: String,
    @SerialName("payment")
    val payment: Int,
    @SerialName("afterPaymentBalance")
    val afterPaymentBalance: Int,
    @SerialName("appliedRate")
    val appliedRate: String
)