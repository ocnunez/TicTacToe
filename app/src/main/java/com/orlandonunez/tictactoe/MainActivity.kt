package com.orlandonunez.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Tic Tac Toe",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        Header(playerTurn.value)

        Board(moves)
    }


}

@Composable
fun Header(playerTurn: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val playerBoxColor = if (playerTurn) Color.Blue else Color.LightGray
        val aiBoxColor = if (playerTurn) Color.LightGray else Color.Green

        Box(
            modifier = Modifier
                .width(100.dp)
                .background(playerBoxColor)
        ) {
            Text(
                text = "Player", modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.width(50.dp))

        Box(
            modifier = Modifier
                .width(100.dp)
                .background(aiBoxColor)
        ) {
            Text(
                text = "AI", modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
            )
        }
    }

}

@Composable
fun Board(moves: List<Boolean?>) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(32.dp)
            .background(Color.LightGray)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth()
                    .background(Color.Black)
            ) {}
            Row(
                modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth()
                    .background(Color.Black)
            ) {}
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .width(2.dp)
                    .fillMaxHeight()
                    .background(Color.Black)
            ) {}
            Column(
                modifier = Modifier
                    .width(2.dp)
                    .fillMaxHeight()
                    .background(Color.Black)
            ) {}
        }
        Column(modifier = Modifier.fillMaxSize()) {
            for (i in 0..2) {
                Row(modifier = Modifier.weight(1f)) {
                    for (j in 0..2) {
                        Column(modifier = Modifier.weight(1f)) {
                            GetComposableFromMove(move = moves[i * 3 + j])
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GetComposableFromMove(move: Boolean?) {
    when (move) {
        true -> Image(
            painter = painterResource(id = R.drawable.ic_x),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(Color.Blue)
        )
        false -> Image(
            painter = painterResource(id = R.drawable.ic_o),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(Color.Green)
        )
        null -> Image(
            painter = painterResource(id = R.drawable.ic_null),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}