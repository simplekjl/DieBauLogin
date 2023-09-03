package com.example.diebaulogin.data.di

import com.example.diebaulogin.data.remote.ServerApi
import com.example.diebaulogin.data.repository.ServerRepositoryImpl
import com.example.diebaulogin.domain.repository.ServerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideServerRepository(
        serverApi: ServerApi
    ): ServerRepository = ServerRepositoryImpl(serverApi)
}