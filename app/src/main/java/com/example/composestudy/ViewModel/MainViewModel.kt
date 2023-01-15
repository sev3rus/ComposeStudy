package com.example.composestudy.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.example.composestudy.Model.TextChangeUiState
import com.example.composestudy.Model.onNameClick
import com.example.composestudy.Model.onValueChanged
import com.example.composestudy.Model.reset
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel(){

    var textChangeUiState by mutableStateOf(TextChangeUiState())
    private set


    fun getNames() = listOf("shortName", "LooongName")


    fun onNameClick(name: String){
        textChangeUiState = textChangeUiState.onNameClick(name)
    }

    fun onValueChanged(value: TextFieldValue){
        textChangeUiState = textChangeUiState.onValueChanged(value)
    }

    fun dismissBottomTextField(){
        textChangeUiState = textChangeUiState.reset()
    }
}