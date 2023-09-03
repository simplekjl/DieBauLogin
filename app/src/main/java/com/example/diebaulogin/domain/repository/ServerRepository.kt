package com.example.diebaulogin.domain.repository

import com.example.diebaulogin.domain.model.Login
import com.example.diebaulogin.domain.model.Signup
import com.example.diebaulogin.util.Resource
import kotlinx.coroutines.flow.Flow

interface ServerRepository {
    suspend fun login(login: Login): Flow<Resource<Boolean>>
    suspend fun signUp(signUp: Signup): Flow<Resource<Boolean>>
    suspend fun logout(): Flow<Resource<Boolean>>
    suspend fun forgotPassword(email: String): Flow<Resource<Boolean>>
}