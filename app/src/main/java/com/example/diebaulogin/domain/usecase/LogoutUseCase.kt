package com.example.diebaulogin.domain.usecase

import com.example.diebaulogin.domain.repository.ServerRepository
import com.example.diebaulogin.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val sessionRepository: ServerRepository,
) {

    suspend operator fun invoke(): Flow<Resource<Boolean>> {
        // we can clean session here in case is needed
        return sessionRepository.logout()
    }
}