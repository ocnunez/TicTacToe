package com.orlandonunez.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.orlandonunez.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TicTacToeScreen()
                }
            }
        }
    }
}

@Composable
fun TicTacToeScreen() {
    // true = players turn, false = AI's turn, null = no move
    val playerTurn = remember { mutableStateOf(true) }
    val moves = remember {
        mutableStateListOf<Boolean?>(
            true,
            null,
            false,
            null,
            null,
            false,
            true,
            null,
            null
        )
    }

    Header(playerTurn.value)

    Board(moves)

}

@Composable
fun Header(playerTurn: Boolean) {

}

@Composable
fun Board(moves: List<Boolean?>) {

}