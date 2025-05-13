package org.sopt.starbanking.data.dto.base

import kotlinx.serialization.SerialName

data class BaseResponse<T>(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: T? = null
)