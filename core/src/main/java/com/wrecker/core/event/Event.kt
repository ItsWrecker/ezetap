package com.wrecker.core.event

sealed class Event<out R> {
    data class Success<out T>(val value: T): Event<T>()
    data class Error(val error: String, val cause: Exception? = null): Event<Nothing>()
    object Loading : Event<Nothing>()
}