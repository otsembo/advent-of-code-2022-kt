package day_1

import java.io.File

// DAY 1 => https://adventofcode.com/2022/day/1

fun solution(): Int{
    // max calories
    var calories = 0
    var currElfCalories = 0

    // solution
    File("src/main/kotlin/day_1/input.txt").forEachLine {
        val data = it.trim()
        currElfCalories = if (data.isEmpty()){
            calories = calories.coerceAtLeast(currElfCalories); 0
        } else currElfCalories + data.toInt()
    }

    return calories
}