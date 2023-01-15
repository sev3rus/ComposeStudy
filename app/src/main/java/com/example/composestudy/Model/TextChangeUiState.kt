package com.example.composestudy.Model

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue

data class TextChangeUiState(
    val text: TextFieldValue = TextFieldValue(),
    val withName: Boolean = false
)

fun TextChangeUiState.onNameClick(name: String) = copy(
    text = text.copy(
        text = "@$name ",
        selection = TextRange(name.length + 2)
    ),
    withName = true
)

fun TextChangeUiState.onValueChanged(value: TextFieldValue) = copy(
    text = value
)

fun TextChangeUiState.reset() = copy(
    text = TextFieldValue(),
    withName = false
)