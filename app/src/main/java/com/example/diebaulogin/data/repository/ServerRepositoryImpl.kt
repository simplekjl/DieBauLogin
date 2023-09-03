package com.example.diebaulogin.data.repository

import com.example.diebaulogin.data.remote.ServerApi
import com.example.diebaulogin.domain.model.Login
import com.example.diebaulogin.domain.model.Signup
import com.example.diebaulogin.domain.repository.ServerRepository
import com.example.diebaulogin.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Mock class that can hold the reference to an API
 */
class ServerRepositoryImpl(
    private val serverApi: ServerApi
) : ServerRepository {

    override suspend fun login(login: Login): Flow<Resource<Boolean>> = flow {
        emit(serverApi.someService())
    }

    override suspend fun signUp(signUp: Signup): Flow<Resource<Boolean>> = flow {
        emit(serverApi.someService())
    }

    override suspend fun logout(): Flow<Resource<Boolean>> = flow {
        emit(serverApi.someService())
    }

    override suspend fun forgotPassword(email: String): Flow<Resource<Boolean>> = flow {
        emit(serverApi.someService())
    }
}