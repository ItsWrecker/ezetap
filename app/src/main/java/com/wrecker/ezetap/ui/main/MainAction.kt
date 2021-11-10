package com.wrecker.ezetap.ui.main

import com.wrecker.core.base.Action
import com.wrecker.network.entities.ResponseEntities

sealed class MainAction : Action {

    data class FetchUI(val url: String) : MainAction()
    data class OnUiResponse(val data: ResponseEntities.UiResponse) : MainAction()
    data class FetchImage(val url: String) : MainAction()
    data class UpdateNameValue(val value: String ): MainAction()
    data class UpdatePhoneValue(val value: String ): MainAction()
    data class UpdateCityValue(val value: String ): MainAction()

}
