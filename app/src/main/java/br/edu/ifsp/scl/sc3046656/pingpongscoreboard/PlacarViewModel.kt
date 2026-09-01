package br.edu.ifsp.scl.sc3046656.pingpongscoreboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlacarViewModel : ViewModel() {
    private val _counterA = MutableStateFlow(0)
    val counterA: StateFlow<Int> = _counterA.asStateFlow()

    private val _counterB = MutableStateFlow(0)
    val counterB: StateFlow<Int> = _counterB.asStateFlow()

    fun incrementA(){
        _counterA.value++
    }
    fun incrementB(){
        _counterB.value++
    }
    fun reiniciar(){
        _counterA.value = 0 ; _counterB.value = 0
    }
}