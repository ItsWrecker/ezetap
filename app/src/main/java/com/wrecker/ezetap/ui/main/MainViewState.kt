package com.wrecker.ezetap.ui.main

import com.wrecker.core.base.State
import com.wrecker.network.entities.ResponseEntities

data class MainViewState(
    val shouldShowProgress: Boolean = false,
    val uiData: ResponseEntities.UiResponse? = null,
    val imageResponse: ResponseEntities.ImageResponse? = null,
    val textName: String = "",
    val textPhone: String = "",
    val textCity: String = "",
) : State
