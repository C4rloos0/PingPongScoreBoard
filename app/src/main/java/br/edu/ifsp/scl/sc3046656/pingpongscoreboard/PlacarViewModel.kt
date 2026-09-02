package br.edu.ifsp.scl.sc3046656.pingpongscoreboard


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class PlacarViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var counterA by mutableIntStateOf(savedStateHandle["counterA"] ?: 0)
        private set
    var counterB by mutableIntStateOf(savedStateHandle["counterB"] ?: 0)
        private set

    private fun attCounterA(value: Int){
        counterA = value
        savedStateHandle["counterA"] = value
    }

    private fun attCounterB(value: Int){
        counterB = value
        savedStateHandle["counterB"] = value
    }


    fun incrementA(){
        attCounterA(counterA+1)
    }
    fun incrementB(){
        attCounterB(counterB+1)
    }
    fun reiniciar(){
        attCounterA(0)
        attCounterB(0)
    }
}