package day_6

import java.io.File

// DAY 6 => https://adventofcode.com/2022/day/6

fun daySix(): Int{

    // read the input line
    val input = File("src/main/kotlin/day_6/input.txt").readLines()[0]

    // loop through index and character
    for (index in input.indices){
        val endInd = if((14 + index ) <= input.length) (13 + index) else (input.length - 1)
        val sub = input.substring(index .. endInd)
        val subSet = sub.toCharArray().toSet()
        if(subSet.size == sub.length){
            return (index + subSet.size)
        }
    }

    return -1
}