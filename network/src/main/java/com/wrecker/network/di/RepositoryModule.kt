package com.wrecker.network.di

import com.wrecker.network.repositories.Repository
import com.wrecker.network.repositories.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindRepository(impl: RepositoryImpl): Repository
}