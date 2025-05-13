package org.sopt.starbanking.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.starbanking.data.service.StarBankingService
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun providesAuthService(retrofit: Retrofit): StarBankingService =
        retrofit.create(StarBankingService::class.java)
}