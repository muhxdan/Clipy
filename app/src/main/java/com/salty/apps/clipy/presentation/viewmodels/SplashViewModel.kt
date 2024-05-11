package com.salty.apps.clipy.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    private val splashShowFlow: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val isSplashShow: StateFlow<Boolean> get() = splashShowFlow.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1000)
            splashShowFlow.value = false
        }
    }
}