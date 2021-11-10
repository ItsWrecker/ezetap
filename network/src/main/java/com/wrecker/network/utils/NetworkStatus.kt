package com.wrecker.network.utils


sealed class NetworkStatus<out R> {

    data class Success<out T>(val value: T) : NetworkStatus<T>()
    data class Error(val error: String, val cause: Exception? = null) : NetworkStatus<Nothing>()
    object Loading : NetworkStatus<Nothing>()

}
