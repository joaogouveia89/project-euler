import base.*
import helpers.getPrimesList

class DistinctPrimesFactors: Solution {
	private val primes = getPrimesList(1000000)
	private val factorsMap = mutableMapOf<Long, List<Long>>()

	override val rightSolution = 134043L
	override fun solve(): Long {
		var consec = false
		var currentNum = 4L

		while (!consec){
			val factors = getPrimeFactors(currentNum)
			factorsMap[currentNum] = factors
			consec = factorsMap[currentNum]?.distinct()?.size == 4 &&
					factorsMap[currentNum - 1]?.distinct()?.size == 4 &&
					factorsMap[currentNum - 2]?.distinct()?.size == 4 &&
					factorsMap[currentNum - 3]?.distinct()?.size == 4
			currentNum++
		}

		return currentNum - 4
	}

	private fun getPrimeFactors(n: Long): List<Long>{
		val factors = mutableListOf<Long>()
		var current = n
		while (current != 1L){
			factorsMap[current]?.let { items ->
				factors.addAll(items)
				current = 1
			}
			if(current != 1L){
				val prime = primes.first { current % it == 0L }
				factors.add(prime)
				current /= prime
			}
		}
		return factors
	}
 }