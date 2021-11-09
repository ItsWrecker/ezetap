package com.wrecker.ezetap.ui.main

import com.wrecker.core.base.Reducer
import javax.inject.Inject

class MainReducer @Inject constructor() : Reducer<MainViewState, MainAction> {
    override fun reduce(currentState: MainViewState, action: MainAction): MainViewState {
        return when (action) {

            else -> currentState
        }
    }


}