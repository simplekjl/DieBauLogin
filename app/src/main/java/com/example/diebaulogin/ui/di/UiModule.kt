package com.example.diebaulogin.ui.di

import com.example.diebaulogin.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UiModule {
    @Provides
    @Singleton
    fun providesNavigator(): Navigator = Navigator()
}