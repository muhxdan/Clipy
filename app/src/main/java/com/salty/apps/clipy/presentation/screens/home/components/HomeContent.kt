package com.salty.apps.clipy.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.salty.apps.clipy.domain.model.Video
import com.salty.apps.clipy.presentation.viewmodels.HomeViewModel
import com.salty.apps.clipy.presentation.viewmodels.shared.SharedViewModel

@Composable
fun HomeContent(
    innerPadding: PaddingValues,
    videos: List<Video>,
    value: String,
    setValue: (String) -> Unit,
    homeViewModel: HomeViewModel,
    focusManager: FocusManager,
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
    lazyListState: LazyListState
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 15.dp)
    ) {
        SearchBar(value, setValue, focusManager, homeViewModel)
        VideoList(videos, navController, sharedViewModel, focusManager, lazyListState)
    }
}