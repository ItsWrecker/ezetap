package com.wrecker.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : State, A : Action> : ViewModel() {


    /**
     * These abstract variable needs to be initialize on [BaseViewModel] child's class.
     */
    abstract val store: Store<S, A>

    abstract val state: StateFlow<S>

    /**
     * Function to dispatch all the action[A] performed by the user.
     * and also the action needs to be trigger while processing the user action[A].
     */
    protected fun dispatch(action: A) {
        viewModelScope.launch {
            store.dispatch(action)
        }
    }
}