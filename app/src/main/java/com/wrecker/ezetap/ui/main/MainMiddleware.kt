package com.wrecker.ezetap.ui.main

import com.wrecker.core.base.Middleware
import com.wrecker.core.base.Store
import javax.inject.Inject

class MainMiddleware @Inject constructor(

) : Middleware<MainViewState, MainAction> {
    override suspend fun process(
        action: MainAction,
        currentState: MainViewState,
        store: Store<MainViewState, MainAction>
    ) {
        when (action) {

            else -> Unit
        }
    }

}