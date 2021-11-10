package com.wrecker.ezetap.ui.main

import android.util.Log
import com.wrecker.core.base.Middleware
import com.wrecker.core.base.Store
import com.wrecker.network.repositories.Repository
import com.wrecker.network.utils.NetworkStatus
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

const val TAG = "DATA"

class MainMiddleware @Inject constructor(
    private val repository: Repository
) : Middleware<MainViewState, MainAction> {
    override suspend fun process(
        action: MainAction,
        currentState: MainViewState,
        store: Store<MainViewState, MainAction>
    ) {
        when (action) {
            is MainAction.FetchUI -> processUiRequest(action, store)
            is MainAction.FetchImage -> processImageRequest(action, store)
            else -> Unit
        }
    }

    private suspend fun processUiRequest(
        action: MainAction.FetchUI,
        store: Store<MainViewState, MainAction>
    ) {
        repository.fetchUI(action.url).collect {
            when (it) {
                is NetworkStatus.Error -> Unit
                is NetworkStatus.Loading -> Unit
                is NetworkStatus.Success -> store.dispatch(MainAction.OnUiResponse(it.value.toString()))
            }
        }
    }

    private fun processImageRequest(
        action: MainAction.FetchImage,
        store: Store<MainViewState, MainAction>
    ) {
        TODO("Not yet implemented")
    }

}