package com.salty.apps.clipy.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.salty.apps.clipy.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel()