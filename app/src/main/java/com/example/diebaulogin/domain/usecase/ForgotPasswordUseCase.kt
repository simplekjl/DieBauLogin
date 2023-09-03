package com.example.diebaulogin.domain.usecase

import com.example.diebaulogin.domain.repository.ServerRepository
import com.example.diebaulogin.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ForgotPasswordUseCase @Inject constructor(
    private val loginRepository: ServerRepository
) {

    suspend operator fun invoke(email: String): Flow<Resource<Boolean>> =
        loginRepository.forgotPassword(email)
}