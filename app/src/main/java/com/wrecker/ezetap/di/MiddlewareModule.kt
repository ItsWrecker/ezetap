package com.wrecker.ezetap.di

import com.wrecker.core.base.Middleware
import com.wrecker.ezetap.ui.main.MainAction
import com.wrecker.ezetap.ui.main.MainMiddleware
import com.wrecker.ezetap.ui.main.MainViewState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface MiddlewareModule {

    @Binds
    @Singleton
    fun bindMainMiddleware(impl: MainMiddleware): Middleware<MainViewState, MainAction>

}