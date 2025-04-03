import base.Solution
import ext.nUmOfDivisors

class HighlyDivisibleTriangularNumber : Solution {
    private val divisorsRoof = 500

    override val rightSolution = 76576500L

    override fun solve(): Long {
        var currentNumber = 1L
        var lastOfSequence = 2L
        var numOfDivisors = 0L

        while (numOfDivisors <= divisorsRoof) {
            currentNumber += lastOfSequence
            numOfDivisors = currentNumber.nUmOfDivisors()
            lastOfSequence++
        }
        return currentNumber
    }
}