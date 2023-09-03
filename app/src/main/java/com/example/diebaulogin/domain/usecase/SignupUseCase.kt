package com.example.diebaulogin.domain.usecase

import com.example.diebaulogin.domain.model.Signup
import com.example.diebaulogin.domain.repository.ServerRepository
import com.example.diebaulogin.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val loginRepository: ServerRepository,
) {
    suspend operator fun invoke(signup: Signup): Flow<Resource<Boolean>> =
        loginRepository.signUp(signup)
}