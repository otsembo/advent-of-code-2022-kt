package day_4

import java.io.File

// DAY 4 => https://adventofcode.com/2022/day/4

fun dayFour(): Int{

    var pairs = 0

    File("src/main/kotlin/day_4/input.txt").forEachLine {
        val pairData = it.split(',')

        val setOne = pairData[0].split('-')
        val setTwo = pairData[1].split('-')

        var rangeOne = 0..0
        var rangeTwo = 0..0

        if (setOne.size > 1){
            rangeOne = setOne[0].toInt() .. setOne[1].toInt()
        }

        if(setTwo.size > 1){
            rangeTwo = setTwo[0].toInt() .. setTwo[1].toInt()
        }

        if(setOne.size == 1){
            rangeOne = setOne[0].toInt() .. setOne[0].toInt()
        }

        if(setTwo.size == 1){
            rangeTwo = setTwo[0].toInt() .. setTwo[0].toInt()
        }

        val l1 = rangeOne.toList()
        val l2 = rangeTwo.toList()

        val n1 = l1.size
        val n2 = l2.size

//        if(l1[0] >= l2[0] && l1[n1-1] <= l2[n2-1]  || l2[0] >= l1[0] && l2[n2-1] <= l1[n1-1] ){
//            pairs += 1
//            //println("1=>${pairData[0]}, 2=>${pairData[1]}")
//        }

        if( (l1[0] >= l2[0] && l1[0] <= l2[n2-1]) || (l1[0] <= l2[0] && l2[0] <= l1[n1-1])  ) {
            pairs += 1
        }

    }


    return pairs

}