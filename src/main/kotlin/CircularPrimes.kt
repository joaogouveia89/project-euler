import base.*
import helpers.getPrimesList


class CircularPrimes : Solution {
    override val rightSolution = 55L

    private fun generateRotations(str: String): Set<String> = str.indices.map { str.drop(it) + str.take(it) }.toSet()

    override fun solve(): Long {
		val primesList = getPrimesList(1000000L).toSet()
        var numOfCircularPrimes = 0
        val checked = mutableSetOf<Long>()

        for(n in primesList){
            if(n in checked) continue
            val rotations = generateRotations(n.toString()).map { it.toLong() }.toSet()
            if(rotations.all { it in primesList }){
                numOfCircularPrimes += rotations.size
                checked.addAll(rotations)
            }
        }
        return numOfCircularPrimes.toLong()
    }
}