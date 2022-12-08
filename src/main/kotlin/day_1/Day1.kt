package day_1

import java.io.File

// DAY 1 => https://adventofcode.com/2022/day/1

fun dayOne(): Triple<Int, Int, Int>{
    // max calories
    var currElfCalories = 0
    val caloriesList:MutableList<Int>  = emptyList<Int>().toMutableList()
    File("src/main/kotlin/day_1/input.txt").forEachLine {
        val data = it.trim()

        if(data.isEmpty()){
            caloriesList.add(currElfCalories)
            currElfCalories = 0
        }else{ currElfCalories += data.toInt() }
    }

    caloriesList.sortDescending()
    return Triple(first = caloriesList[0], second = caloriesList[1], third = caloriesList[2])
}