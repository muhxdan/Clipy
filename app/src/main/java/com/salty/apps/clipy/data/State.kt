package com.salty.apps.clipy.data

sealed class State<out T> {
    data class Success<out T>(val data: T? = null) : State<T>()
    data class Error<out T>(val message: String) : State<T>()
    data object Loading : State<Nothing>()
}