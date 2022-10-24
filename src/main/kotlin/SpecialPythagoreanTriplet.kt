import base.Solution
import kotlin.math.pow

class SpecialPythagoreanTriplet : Solution {
    override val rightSolution = 31875000L
    override fun solve(): Long {
        var a = 0.0
        var b = 0.0
        var c = 0.0

        var isCriteriaSatisfied = false

        while (!isCriteriaSatisfied) {
            if (a < b) a++
            else if (b < c) {
                a = 0.0
                b++
            } else {
                b = 0.0
                c++
            }

            isCriteriaSatisfied = (a + b + c) == 1000.0 && (a.pow(2.0) + b.pow(2.0) == c.pow(2.0))
        }

        return (a * b * c).toLong()
    }
}