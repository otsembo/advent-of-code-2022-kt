package day_3

import java.io.File

fun dayThree(): Int{

    var score = 0

    File("src/main/kotlin/day_3/input.txt").forEachLine { it ->
        // line metadata
        val size = it.length
        val mid = size / 2
        val p1 = it.substring(0, mid)
        val p2 = it.substring(mid)

        // common characters in set
        val commonChars: MutableSet<Char> = emptySet<Char>().toMutableSet()

        p1.toCharArray().forEach { c: Char ->
            if (p2.contains(c)){
                commonChars.add(c)
            }
        }

        commonChars.forEach {cc ->
            score += calculateWeight(cc)
        }


    }

    return score
}

fun calculateWeight(char: Char): Int{
    val lowerScores = 1..26
    val upperScores = 27..52

    val upperAlphabet = 'A'..'Z'
    val lowerAlphabet = 'a'..'z'

    return when(char){
        in  lowerAlphabet-> lowerScores.toList()[lowerAlphabet.indexOf(char)]
        in  upperAlphabet -> upperScores.toList()[upperAlphabet.indexOf(char)]
        else -> -1
    }
}
