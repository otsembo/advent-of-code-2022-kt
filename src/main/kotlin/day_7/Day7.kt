package day_7

import java.io.File

// DAY 7 => https://adventofcode.com/2022/day/7

fun daySeven(){

    // file system data
    val fileSystem: List<String> = ArrayList()

    // line number
    var index = 0

    var state: State? = null


    File("src/main/kotlin/day_7/input.txt").forEachLine { line ->
        val lineData = line.split(" ")

        // past line 1
        if(index > 0){

            // command at given point
            if(lineData[0] == "$"){
                println("Command: $line  Interpretation: ${interpret(line)}")
            }

        }

        // add index
        index++

    }
}

// interpret command
fun interpret(command: String) : Pair<Int, String?>{
    val commandDetails = command.split(" ")
    return when(commandDetails[1]){
        "ls" -> Pair(1, null)
        "cd" -> when(commandDetails[2]){ ".." -> Pair(3, "..") else -> Pair(2, commandDetails[2]) }
        else -> Pair(0,"0")
    }
}

enum class State{
    LIST, BACK, FORWARD, COMMAND
}
