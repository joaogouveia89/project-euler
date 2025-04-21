import base.*
import kotlin.math.sqrt

class TriangularPentagonalAndHexagonal : Solution {
    override val rightSolution = 1533776805L

    private fun Int.isPentagonal(): Boolean {
        val x = sqrt(24.0 * this + 1)
        return x % 1 == 0.0 && ((x + 1).toLong() % 6 == 0L)
    }

    private fun Int.isTriangular(): Boolean {
        val x = sqrt(8.0 * this + 1)
        return x % 1 == 0.0 && ((x - 1).toLong() % 2 == 0L)
    }

    override fun solve(): Long {
        var h = 144

        /*
        * triangular = n(n + 1)/2
        * pentagonal = n(3n - 1)/2
        * hexagonal = n(2n - 1)
        *
        *
         */
        var hn = 0
        var found = false

        while (!found){
            hn = h * (2 * h - 1)
            found = hn.isPentagonal() && hn.isTriangular()
            h++
        }

        return hn.toLong()
    }
}