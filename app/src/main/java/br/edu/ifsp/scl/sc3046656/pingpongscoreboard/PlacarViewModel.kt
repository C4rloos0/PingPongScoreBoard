package br.edu.ifsp.scl.sc3046656.pingpongscoreboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PlacarViewModel : ViewModel() {
    var counterA by mutableIntStateOf(0)
        private set
    var counterB by mutableIntStateOf(0)
        private set

    fun incrementA(){counterA++}
    fun incrementB(){counterB++}
    fun reiniciar(){counterA=0;counterB=0}
}