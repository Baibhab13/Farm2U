package com.example.farm2u.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AddItemViewModel: ViewModel() {
    val name = mutableStateOf("")
    val cropType = mutableStateOf("")
    val price = mutableStateOf("")
    val quantity = mutableStateOf("")
}