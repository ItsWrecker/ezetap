package com.wrecker.ezetap.ui.main

import com.wrecker.core.base.State

data class MainViewState(
    val shouldShowProgress: Boolean = false,
    val data: String = ""
) : State
