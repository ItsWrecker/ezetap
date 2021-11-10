package com.wrecker.ezetap.ui.main

import com.wrecker.core.base.Reducer
import javax.inject.Inject

class MainReducer @Inject constructor() : Reducer<MainViewState, MainAction> {
    override fun reduce(currentState: MainViewState, action: MainAction): MainViewState {
        return when (action) {

            is MainAction.OnUiResponse -> stateWithUiResponse(currentState, action)
            is MainAction.UpdateNameValue -> currentState.copy(textName = action.value)
            is MainAction.UpdatePhoneValue -> currentState.copy(textPhone = action.value)
            is MainAction.UpdateCityValue -> currentState.copy(textCity = action.value)
            else -> currentState
        }
    }

    private fun stateWithUiResponse(
        currentState: MainViewState,
        action: MainAction.OnUiResponse
    ): MainViewState = currentState.copy(uiData = action.data)


}