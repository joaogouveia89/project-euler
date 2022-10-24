import base.Solution
import base.isPrime

class TenThousandAndOnePrime : Solution {
    companion object {
        const val GOAL = 10001
    }

    override val rightSolution = 104743L
    override fun solve(): Long {

        var position = 6 // in problem description it says that the 6th prime is 13, so I can move on from here
        var current = 14L

        while (position != GOAL) {
            if (current.isPrime()) {
                position++
            }
            if (position != GOAL) current++
        }

        return current
    }
}