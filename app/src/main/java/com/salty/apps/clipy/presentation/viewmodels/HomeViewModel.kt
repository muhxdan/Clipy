package com.salty.apps.clipy.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salty.apps.clipy.data.State
import com.salty.apps.clipy.domain.model.Video
import com.salty.apps.clipy.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {
    private val _videos: MutableStateFlow<Resource> = MutableStateFlow(Resource())
    private val _allVideos: MutableStateFlow<Resource> = MutableStateFlow(Resource())
    val videos: StateFlow<Resource> get() = _videos

    init {
        fetchVideos()
    }

    private fun fetchVideos() = viewModelScope.launch {
        useCase.fetchVideos().collect { resource ->
            _allVideos.value = when (resource) {
                is State.Loading -> Resource(isLoading = true)
                is State.Success -> Resource(data = resource.data ?: emptyList())
                is State.Error -> {
                    Log.d("HomeViewModel", "fetchVideos: ${resource.message}")
                    Resource(errorMessage = resource.message)
                }
            }
            _videos.value = _allVideos.value
        }
    }

    fun searchVideos(query: String) {
        if (query.trim().isNotEmpty()) {
            val filteredVideos = _allVideos.value.data.filter { video ->
                video.title.contains(query, ignoreCase = true)
            }
            _videos.value = Resource(data = filteredVideos)
        } else {
            _videos.value = _allVideos.value
        }
    }
}

data class Resource(
    val isLoading: Boolean = false,
    val data: List<Video> = emptyList(),
    val errorMessage: String = "",
)
