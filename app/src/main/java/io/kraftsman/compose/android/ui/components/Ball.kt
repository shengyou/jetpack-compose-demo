package io.kraftsman.compose.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ball(
    displayNumber: Int,
    lotteryNumbers: List<Int>
) {
    val background = if (lotteryNumbers.contains(displayNumber)) {
        Color.Red
    } else {
        Color.Gray
    }

    Box(
        Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(background)
    ) {
        Text(
            text = displayNumber.toString(),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .offset(0.dp, 5.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BallPreview() {
    MaterialTheme {
        Ball(
            displayNumber = 1,
            lotteryNumbers = listOf(1, 2, 3, 4, 5, 6)
        )
    }
}
