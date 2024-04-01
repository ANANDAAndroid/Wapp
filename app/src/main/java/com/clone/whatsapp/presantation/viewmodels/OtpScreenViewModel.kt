package com.clone.whatsapp.presantation.viewmodels

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class OtpScreenViewModel @Inject constructor() : ViewModel() {

    var time by mutableStateOf("60")
    init {
        startTimer()
    }
    private fun startTimer() {
        viewModelScope.launch {
            object : CountDownTimer(1000 * 60, 1000) {
                override fun onTick(p0: Long) {
                    time=String.format("%02d", p0 / 1000)
                }
                override fun onFinish() {
                    cancel()
                }
            }.start()

        }

    }
}