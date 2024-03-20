package com.clone.whatsapp.presantation.viewmodels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class SplashViewModel : ViewModel() {

    private val _shouldNavigate:MutableStateFlow<Boolean> = MutableStateFlow(false)
     val shouldNavigate:StateFlow<Boolean> = _shouldNavigate.asStateFlow()

    fun shouldNavigate() {
        Handler(Looper.getMainLooper()).postDelayed({
           _shouldNavigate.value=true
        }, 1000)
    }
}