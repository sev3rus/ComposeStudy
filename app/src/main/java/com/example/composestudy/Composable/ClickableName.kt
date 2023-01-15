package com.example.composestudy.Composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ClickableName(
    name: String,
    onNameClick: (String) -> Unit
){
    val localKeyboardController = LocalSoftwareKeyboardController.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onNameClick(name)
                localKeyboardController?.show()
            }
            .padding(vertical = 10.dp)
    ) {
        Text(
            text = name,
            fontSize = 20.sp
        )
    }
}