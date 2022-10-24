import base.Solution

class MultiplesOf3And5 : Solution {

    companion object {
        const val FLOOR = 3
        const val ROOF = 999
    }

    override val rightSolution: Long = 233168

    override fun solve(): Long {
        var sum = 0L
        for (i in FLOOR..ROOF) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i
            }
        }
        return sum
    }
}