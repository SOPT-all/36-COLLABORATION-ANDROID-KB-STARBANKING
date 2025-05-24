package org.sopt.starbanking.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseAccountInterest(
    @SerialName("savingAccountName")
    val savingAccountName: String,

    @SerialName("accountNumber")
    val accountNumber: String,

    @SerialName("contractPeriod")
    val contractPeriod: Int,

    @SerialName("startDate")
    val startDate: String,

    @SerialName("endDate")
    val endDate: String,

    @SerialName("baseRate")
    val baseRate: String,

    @SerialName("baseEndDate")
    val baseEndDate: String,

    @SerialName("preferentialRates")
    val preferentialRates: List<PreferentialRate>
)

@Serializable
data class PreferentialRate(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("rate")
    val rate: String,

    @SerialName("startDate")
    val startDate: String,

    @SerialName("endDate")
    val endDate: String
)