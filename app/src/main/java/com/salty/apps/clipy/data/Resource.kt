package com.salty.apps.clipy.data

sealed class Resource<out T> {
    data class Success<out T>(val data: T? = null) : Resource<T>()
    data class Error<out T>(val message: String) : Resource<T>()
    data object Loading : Resource<Nothing>()
}