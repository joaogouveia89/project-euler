import base.Solution
import ext.isEven

class EvenFibonacciNumbers : Solution {

    companion object {
        const val ROOF = 4000000
    }

    override val rightSolution = 4613732L

    override fun solve(): Long {
        var currentElement = 2
        var lastElement = 1

        var sumEvens = 0L

        while (currentElement < ROOF) {
            if (currentElement.isEven()) {
                sumEvens += currentElement
            }

            // maybe there's a better way
            currentElement = currentElement.let {
                val sum = currentElement + lastElement
                lastElement = it
                sum
            }

        }

        return sumEvens
    }
}