package com.clone.whatsapp.presantation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PhoneNumberScreenViewModel:ViewModel() {

    private val _isLoading= MutableStateFlow(false)
    val isLoading= _isLoading.asStateFlow()

    fun getLoading()=viewModelScope.launch {
        _isLoading.value=true
        delay(1000)
        _isLoading.value=false
    }

}