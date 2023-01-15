package com.example.composestudy.Composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import com.example.composestudy.ViewModel.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel
){
    val focusRequester = remember {
        FocusRequester()
    }

    LaunchedEffect(mainViewModel.textChangeUiState.withName){
        if (mainViewModel.textChangeUiState.withName){
            focusRequester.requestFocus()
        }
    }

    Box {
        LazyColumn {
            if (!mainViewModel.textChangeUiState.withName){
                item {
                    TextField(
                        value = mainViewModel.textChangeUiState.text,
                        onValueChange = mainViewModel::onValueChanged
                    )
                }
            }
            items(items = mainViewModel.getNames()){
                ClickableName(
                    name = it,
                    onNameClick = mainViewModel::onNameClick
                )
            }
        }
        if (mainViewModel.textChangeUiState.withName){
            BottomTextField(
                value = mainViewModel.textChangeUiState.text,
                onValueChanged = mainViewModel::onValueChanged,
                focusRequester = focusRequester,
                onBack = mainViewModel::dismissBottomTextField
            )
        }

    }
}