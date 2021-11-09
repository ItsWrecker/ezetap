package com.wrecker.ezetap.di.modules

import com.wrecker.core.base.Middleware
import com.wrecker.core.base.Reducer
import com.wrecker.core.base.Store
import com.wrecker.core.dispatchers.DispatcherProviders
import com.wrecker.ezetap.ui.main.MainAction
import com.wrecker.ezetap.ui.main.MainViewState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object StoreModule {

    @Provides
    @Singleton
    fun provideMainStore(
        middleware: Middleware<MainViewState, MainAction>,
        reducer: Reducer<MainViewState, MainAction>,
        dispatcherProviders: DispatcherProviders
    ): Store<MainViewState, MainAction> = Store(
        initialState = MainViewState(),
        reducer = reducer,
        dispatcherProvider = dispatcherProviders,
        middlewares = listOf(middleware)
    )
}