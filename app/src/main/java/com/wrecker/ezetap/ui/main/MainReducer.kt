package com.wrecker.ezetap.ui.main

import com.wrecker.core.base.Reducer
import javax.inject.Inject

class MainReducer @Inject constructor() : Reducer<MainViewState, MainAction> {
    override fun reduce(currentState: MainViewState, action: MainAction): MainViewState {
        return when (action) {

            is MainAction.OnUiResponse -> stateWithUiResponse(currentState, action)
            else -> currentState
        }
    }

    private fun stateWithUiResponse(
        currentState: MainViewState,
        action: MainAction.OnUiResponse
    ): MainViewState = currentState.copy(data = action.data)


}