package com.salty.apps.clipy.presentation.viewmodels.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salty.apps.clipy.domain.model.Video
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {
    private val _dataVideo: MutableStateFlow<SharedResource> = MutableStateFlow(SharedResource())
    val dataVideo: StateFlow<SharedResource> get() = _dataVideo

    fun setDataVideo(video: Video) =
        viewModelScope.launch { _dataVideo.value = SharedResource(data = video) }
}

data class SharedResource(
    val data: Video? = null,
)