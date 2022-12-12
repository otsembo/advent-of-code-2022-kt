package day_5

import java.io.File
import java.util.Stack

// DAY 5 => https://adventofcode.com/2022/day/5

fun dayFive(): List<String>{

    val buildingStacks: List<MutableList<CharSequence>> = mutableListOf(
        ArrayList(), ArrayList(), ArrayList(), ArrayList(),
        ArrayList(), ArrayList(), ArrayList(), ArrayList(),
        ArrayList()
    )

    var isStack = true

    File("src/main/kotlin/day_5/input.txt").forEachLine { line ->
        // check whether we are still on a stack.
        if(isStack){
            val x = line.chunked(4){ chunk -> chunk.trim() }
            x.forEachIndexed{ index: Int, item: CharSequence ->
                if(item.isNotEmpty() && item.toString().toDoubleOrNull() == null){
                    buildingStacks[index].add(item)
                }
            }
        }

        // toggle stack status
        if(line.isNotEmpty() && isStack){
            isStack = line.trim().toCharArray()[0] != '1'
        }

        // go through steps
        if(!isStack && line.isNotEmpty() && line[0] == 'm'){

            val movementData = line.trim().split(' ').filterIndexed { index, _ -> index %2 == 1 }.map { num -> num.toInt() }

            val from = buildingStacks[movementData[1] - 1]
            val to = buildingStacks[movementData[2] - 1]

            val nItems = movementData[0]
            val movementIndices = from.size - nItems until from.size

            println("FROM: $from")
            println("TO: $to")
            println("nItems: $nItems")

            val fromStack: Stack<String> = Stack()

            movementIndices.forEach { _ ->
                fromStack.push(from[0].toString())
                from.removeAt(0)
            }

            // ADD ALL IN STACK ORDER
            to.addAll(0, fromStack)

        }
    }

    val crateList = emptyList<String>().toMutableList()

    buildingStacks.forEach { stack ->
        crateList.add(stack[0].toString())
    }

    return crateList
}