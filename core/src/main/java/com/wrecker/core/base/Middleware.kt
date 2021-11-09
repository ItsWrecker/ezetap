package com.wrecker.core.base

interface Middleware<S : State, A : Action> {
    /**
     * This will process the given [action] and [currentState] and determine if we need to
     * perform any side effects, or trigger a new action.
     *
     * @param[store] This is a reference to the [Store] that dispatched this action. We should only
     * call this with a _new_ action, and not trigger the same action again or risk ending up in a
     * loop.
     */
    suspend fun process(
        action: A,
        currentState: S,
        store: Store<S, A>,
    )



}