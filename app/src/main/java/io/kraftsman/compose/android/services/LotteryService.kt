package io.kraftsman.compose.android.services

class LotteryService {
    fun generate(amount: Int = 49): List<Int> =
        (1..amount).shuffled().take(6)
}
