package day_6

import java.io.File

// DAY 6 => https://adventofcode.com/2022/day/6

fun daySix(): Int{

    // read the input line
    val input = File("src/main/kotlin/day_6/input.txt").readLines()[0]

    val data0 = input.toCharArray()
    val data = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".toCharArray()

    var recordedChars: MutableSet<Char> = emptySet<Char>().toMutableSet()
    var count = 0

    println("INPUT: ${data.toList()}")

    // loop through index and character
    for ((index, character) in data.withIndex()){
        if(!recordedChars.contains(character) && recordedChars.size == 4){
            return (index + 1)
        }else{
            recordedChars.add(character)
        }
//        if(recordedChars.contains(character)){
//            count = 0
//            recordedChars = emptySet<Char>().toMutableSet()
//        }else{
//
//            if(count == 3){
//                return (index + 1)
//            }
//            recordedChars.add(character)
//            count += 1
//        }
    }
    return -1
}