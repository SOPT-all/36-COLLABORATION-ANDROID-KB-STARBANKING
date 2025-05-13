package org.sopt.starbanking.data.service

import org.sopt.starbanking.data.dto.base.BaseResponse
import org.sopt.starbanking.data.dto.response.ResponseAccountState
import retrofit2.http.GET
import retrofit2.http.Path

interface StarBankingService {

    // 특정 적금 계좌 상태 조회
    @GET("/api/v1/accounts/{account-id}/state")
    suspend fun getAccountState(
        @Path("account-id") accountId: Long
    ): BaseResponse<ResponseAccountState>
}