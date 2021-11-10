package com.wrecker.ezetap.ui.main

import com.wrecker.core.base.Action

sealed class MainAction : Action {

    data class FetchUI(val url: String) : MainAction()
    data class OnUiResponse(val data: String) : MainAction()
    data class FetchImage(val url: String) : MainAction()

}
