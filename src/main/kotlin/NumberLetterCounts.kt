import base.Solution
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

class NumberLetterCounts : Solution {

    override val rightSolution = 21124L

    override fun solve() = runBlocking {
        val numberOfLettersOfONETHOUSAND = unitMap[1]!! + nonUnitMap[1000]!!
        for (i in 1 until 1000) {
            tasks.add(
                async {
                    numberOfLetters(i)
                }
            )
        }
        (tasks.awaitAll()
            .sumOf { it } + numberOfLettersOfONETHOUSAND)
            .toLong()
    }


    private fun numberOfLetters(i: Int): Int {
        return if (i <= 19) unitMap[i]!!
        else if (i < 100) numberOfLettersDozen(i)
        else numberOfLettersHundreds(i)
    }

    private fun numberOfLettersDozen(i: Int): Int {
        val units = i % 10
        val dozen = i / 10

        return nonUnitMap[dozen * 10]!! + (unitMap[units] ?: 0)
    }

    private fun numberOfLettersHundreds(i: Int): Int {
        val hundred = i / 100
        val dozen = i % 100
        val numberOfLettersOfAnd = 3

        val sum = unitMap[hundred]!! + nonUnitMap[100]!!

        return if (dozen == 0)
            sum
        else if (dozen < 20)
            sum + numberOfLettersOfAnd + unitMap[dozen]!!
        else
            sum + numberOfLettersOfAnd + numberOfLettersDozen(dozen)
    }

    private val tasks = mutableListOf<Deferred<Int>>()
    private val unitMap = mapOf(
        1 to 3,
        2 to 3,
        3 to 5,
        4 to 4,
        5 to 4,
        6 to 3,
        7 to 5,
        8 to 5,
        9 to 4,
        10 to 3,
        11 to 6,
        12 to 6,
        13 to 8,
        14 to 8,
        15 to 7,
        16 to 7,
        17 to 9,
        18 to 8,
        19 to 8
    )
    private val nonUnitMap = mapOf(
        20 to 6,
        30 to 6,
        40 to 5,
        50 to 5,
        60 to 5,
        70 to 7,
        80 to 6,
        90 to 6,
        100 to 7,
        1000 to 8
    )
}