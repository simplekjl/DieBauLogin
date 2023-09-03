package com.example.diebaulogin.domain.usecase

import com.example.diebaulogin.domain.model.Login
import com.example.diebaulogin.domain.repository.ServerRepository
import com.example.diebaulogin.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: ServerRepository,
) {
    suspend operator fun invoke(login: Login): Flow<Resource<Boolean>> =
        loginRepository.login(login)
}