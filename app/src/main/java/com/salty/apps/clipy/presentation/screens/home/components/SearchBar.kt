package com.salty.apps.clipy.presentation.screens.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.salty.apps.clipy.presentation.viewmodels.HomeViewModel

@Composable
fun SearchBar(
    value: String,
    setValue: (String) -> Unit,
    focusManager: FocusManager,
    homeViewModel: HomeViewModel
) {
    OutlinedTextField(
        value = value,
        shape = RoundedCornerShape(12.dp),
        onValueChange = {
            setValue(it)
            homeViewModel.searchVideos(it)
        },
        placeholder = { Text("Search title") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
    )
}