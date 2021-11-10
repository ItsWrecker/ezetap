package com.wrecker.core.di

import com.wrecker.core.dispatchers.DispatcherProviders
import com.wrecker.core.dispatchers.DispatcherProvidersImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DispatchersModule {

    @Binds
    fun bindDispatcherProvider(impl: DispatcherProvidersImpl): DispatcherProviders
}