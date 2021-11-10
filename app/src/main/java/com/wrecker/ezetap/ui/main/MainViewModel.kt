package com.wrecker.ezetap.ui.main

import androidx.lifecycle.viewModelScope
import com.wrecker.core.base.BaseViewModel
import com.wrecker.core.base.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val _store: Store<MainViewState, MainAction>
) : BaseViewModel<MainViewState, MainAction>() {
    override val store: Store<MainViewState, MainAction>
        get() = _store
    override val state: StateFlow<MainViewState>
        get() = store.state



    init {
        fetchUi("")
    }
    fun fetchUi(url: String) = dispatch(MainAction.FetchUI(url = url))
    fun fetchImage(url: String) = dispatch(MainAction.FetchImage(url = url))
}
