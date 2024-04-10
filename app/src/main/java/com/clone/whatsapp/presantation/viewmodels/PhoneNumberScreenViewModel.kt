package com.clone.whatsapp.presantation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PhoneNumberScreenViewModel:ViewModel() {

    private val _isLoading= MutableStateFlow(false)
    val isLoading= _isLoading.asStateFlow()
     val abce=true


    fun getLoading()=viewModelScope.launch {
        _isLoading.value=true
        delay(1000)
        _isLoading.value=false
    }


       val abc= flow<Int> {
            (1..100).forEach {
                delay(500)
                println("counter running $it")
                emit(1)
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L),0)


}