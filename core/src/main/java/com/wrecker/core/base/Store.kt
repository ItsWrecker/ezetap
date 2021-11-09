package com.wrecker.core.base

import com.wrecker.core.dispatchers.DispatcherProviders
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ActivityRetainedScoped
class Store<S : State, A : Action> @Inject constructor(
    initialState: S,
    private val reducer: Reducer<S, A>,
    private val middlewares: List<Middleware<S, A>> = emptyList(),
    private val dispatcherProvider: DispatcherProviders
) {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state

    private val currentState: S
        get() = _state.value

    suspend fun dispatch(action: A) {
        withContext(dispatcherProvider.io) {
            middlewares.forEach { middleware ->
                middleware.process(action, currentState, this@Store)
            }
            _state.value = reducer.reduce(currentState, action)
        }

    }

}