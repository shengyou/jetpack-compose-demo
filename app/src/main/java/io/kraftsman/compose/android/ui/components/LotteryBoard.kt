package io.kraftsman.compose.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kraftsman.compose.android.services.LotteryService

@Composable
fun LotteryBoard() {
    var lotteryNumbers by remember { mutableStateOf(listOf<Int>()) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "做一個發財夢",
            fontSize = 30.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        (1..49).chunked(7).forEach { group ->
            Row {
                group.forEach {
                    Box(
                        modifier = Modifier.padding(2.dp)
                    ) {
                        Ball(it, lotteryNumbers)
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            onClick = {
                lotteryNumbers = LotteryService().generate(49)
        }) {
            Text(
                text = "選號 🎲",
                fontSize = 30.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LotteryBoardPreview() {
    MaterialTheme {
        LotteryBoard()
    }
}
