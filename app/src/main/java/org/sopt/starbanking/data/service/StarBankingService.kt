package org.sopt.starbanking.data.service

import org.sopt.starbanking.data.dto.base.BaseResponse
import org.sopt.starbanking.data.dto.response.ResponseAccountInterest
import org.sopt.starbanking.data.dto.response.ResponseAccountState
import org.sopt.starbanking.data.dto.response.ResponseSavingsState
import retrofit2.http.GET
import retrofit2.http.Path

interface StarBankingService {

    // 특정 적금 계좌 상태 조회
    @GET("/api/v1/accounts/{account-id}/state")
    suspend fun getAccountState(
        @Path("account-id") accountId: Long
    ): BaseResponse<ResponseAccountState>

    //적금 상세 조회
    @GET("/api/v1/accounts/{account-id}")
    suspend fun getSavingsState(
        @Path("account-id") accountId:Long
    ): BaseResponse<ResponseSavingsState>

    // 특정 적금 계좌 이율 조회
    @GET("/api/v1/accounts/{account-id}/rates")
    suspend fun getAccountInterest(
        @Path("account-id") accountId: Long
    ): BaseResponse<ResponseAccountInterest>
}