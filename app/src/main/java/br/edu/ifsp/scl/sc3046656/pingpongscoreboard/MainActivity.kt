package br.edu.ifsp.scl.sc3046656.pingpongscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3046656.pingpongscoreboard.ui.theme.PingPongScoreBoardTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PingPongScoreBoardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DuasTelas(Modifier.fillMaxSize().padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DuasTelas(modifier: Modifier = Modifier,
              viewModel: PlacarViewModel = viewModel()) {

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        CounterTimeA(modifier = Modifier.weight(1f),
            counterA = viewModel.counterA,
            onIncrement = {viewModel.incrementA()})
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {viewModel.reiniciar()}
        ){
            Text("Reiniciar Partida")
        }
        CounterTimeB(modifier = Modifier.weight(1f),
            counterB = viewModel.counterB,
            onIncrement = {viewModel.incrementB()})
    }
}

@Composable
fun CounterTimeA(modifier: Modifier = Modifier, counterA: Int, onIncrement: () -> Unit){
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Button(
            modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter),
            onClick = onIncrement
        ) {
            Text(text = "+1")
        }
        Text(
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center,
            fontSize = 48.sp,
            text = counterA.toString()
        )
    }

}


@Composable
fun CounterTimeB(modifier: Modifier = Modifier, counterB: Int, onIncrement: () -> Unit){
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            fontSize = 48.sp,
            text = counterB.toString()
        )
        Button(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            onClick = onIncrement
        ) {
            Text(text = "+1")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingDuasTelas(){
    PingPongScoreBoardTheme() {
        DuasTelas()
    }
}

