package com.example.diebaulogin.domain.di

import com.example.diebaulogin.domain.repository.ServerRepository
import com.example.diebaulogin.domain.usecase.ForgotPasswordUseCase
import com.example.diebaulogin.domain.usecase.LoginUseCase
import com.example.diebaulogin.domain.usecase.LogoutUseCase
import com.example.diebaulogin.domain.usecase.SignupUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideLogoutUseCase(
        sessionRepository: ServerRepository,
    ): LogoutUseCase = LogoutUseCase(sessionRepository)

    @Provides
    fun provideLoginUseCase(
        sessionRepository: ServerRepository,
    ): LoginUseCase = LoginUseCase(sessionRepository)

    @Provides
    fun provideSignupUseCase(
        sessionRepository: ServerRepository,
    ): SignupUseCase = SignupUseCase(sessionRepository)

    @Provides
    fun provideForgotPasswordUseCase(
        sessionRepository: ServerRepository,
    ): ForgotPasswordUseCase = ForgotPasswordUseCase(sessionRepository)
}