import base.*
import ext.generateAllPermutations
import ext.isPrime

class PandigitalPrime: Solution { 
	override val rightSolution = 7652413L
	override fun solve(): Long {
		val possibleNumOfDigits = (2..9).filter {
			(1..it).sum() % 3 != 0
		}

		val permutations = possibleNumOfDigits.map {
			(1..it).toSet().joinToString("").generateAllPermutations()
		}.flatten().map { it.toLong() }

		val primePermutations = permutations.filter { it.isPrime() }

		return primePermutations.max()
	}
 }