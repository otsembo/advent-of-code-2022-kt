package day_2

import java.io.File

fun dayTwo(): Int {

    var score = 0

    File("src/main/kotlin/day_2/input.txt").forEachLine {
        val game = it.trim().split(" ")
        val gameScore = getScore(p1 = game[0].uppercase(), p2 = game[1].uppercase())
        score += gameScore.toList().sum()
    }

    return score
}

private fun getScore(p1: String = "A", p2: String = "X"): Pair<Int, Int>{
    val gamePair = Pair(p1, p2)
    val gInfo = arrayOf("A", "B", "C", "X", "Y", "Z")
    val gData = arrayOf(1, 2, 3)
    val oData = arrayOf(0, 3, 6)
    return when(gamePair){

        // 1: You need to lose
        // A - X =>
        Pair(gInfo[0], gInfo[3]) -> Pair(gData[2], oData[0])
        // B - X =>
        Pair(gInfo[1], gInfo[3]) -> Pair(gData[0], oData[0])
        // C - X =>
        Pair(gInfo[2], gInfo[3]) -> Pair(gData[1], oData[0])

        // 2: You need to draw
        // A - Y =>
        Pair(gInfo[0], gInfo[4]) -> Pair(gData[0], oData[1])
        // B - Y =>
        Pair(gInfo[1], gInfo[4]) -> Pair(gData[1], oData[1])
        // C - Y =>
        Pair(gInfo[2], gInfo[4]) -> Pair(gData[2], oData[1])

        // 3: You need to win
        // A - Z =>
        Pair(gInfo[0], gInfo[5]) -> Pair(gData[1], oData[2])
        // B - Z =>
        Pair(gInfo[1], gInfo[5]) -> Pair(gData[2], oData[2])
        // C - Z =>
        Pair(gInfo[2], gInfo[5]) -> Pair(gData[0], oData[2])

        else -> Pair(0,0)
    }
}