package com.wrecker.ezetap.di

import com.wrecker.core.base.Reducer
import com.wrecker.ezetap.ui.main.MainAction
import com.wrecker.ezetap.ui.main.MainReducer
import com.wrecker.ezetap.ui.main.MainViewState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface ReducerModule {


    @Binds
    @Singleton
    fun bindMainReducer(impl: MainReducer): Reducer<MainViewState, MainAction>

}