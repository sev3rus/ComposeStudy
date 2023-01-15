package com.example.composestudy.Composable

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun BoxScope.BottomTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onValueChanged: (TextFieldValue) -> Unit,
    focusRequester: FocusRequester? = null,
    onBack: () -> Unit
){
    BackHandler(onBack = onBack)
    Column(
        modifier = modifier.align(Alignment.BottomStart)
    ) {
        TextField(
            modifier = focusRequester?.let { Modifier.focusRequester(it) } ?: Modifier,
            value = value,
            onValueChange = onValueChanged
        )
    }
}