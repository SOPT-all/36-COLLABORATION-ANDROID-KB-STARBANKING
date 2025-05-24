package org.sopt.starbanking.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseAccountState(
    @SerialName("depositCount")
    val depositCount: Int,
    @SerialName("accountState")
    val accountState: String,
    @SerialName("lastTransaction")
    val lastTransaction: String,
    @SerialName("contractPeriod")
    val contractPeriod: Int
)