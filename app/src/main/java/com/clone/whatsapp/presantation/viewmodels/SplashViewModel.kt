package com.clone.whatsapp.presantation.viewmodels


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {

     val shouldNavigate = mutableStateOf(false)

    init {
        shouldNavigate()
    }

    private fun shouldNavigate() {
        viewModelScope.launch {
            delay(1000)
            shouldNavigate.value=true
        }
    }
}