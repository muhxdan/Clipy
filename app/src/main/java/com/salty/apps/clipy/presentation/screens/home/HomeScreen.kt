package com.salty.apps.clipy.presentation.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.salty.apps.clipy.presentation.screens.home.components.HomeContent
import com.salty.apps.clipy.presentation.screens.home.components.HomeTopBar
import com.salty.apps.clipy.presentation.viewmodels.HomeViewModel
import com.salty.apps.clipy.presentation.viewmodels.shared.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
    homeViewModel: HomeViewModel = hiltViewModel(),
    focusManager: FocusManager = LocalFocusManager.current,
) {
    val (value, setValue) = remember { mutableStateOf("") }
    val lazyListState = rememberLazyListState()
    val hasScrolled by remember { derivedStateOf { lazyListState.layoutInfo.totalItemsCount > 2 } }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(canScroll = { hasScrolled })

    val videos by homeViewModel.videos.collectAsState()

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { HomeTopBar(scrollBehavior = scrollBehavior) },
        content = { innerPadding ->
            HomeContent(
                innerPadding,
                videos.data,
                value,
                setValue,
                homeViewModel,
                focusManager,
                navController,
                sharedViewModel,
                lazyListState
            )
        })
}