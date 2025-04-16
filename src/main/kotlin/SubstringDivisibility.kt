import base.*
import ext.generateAllPermutations
import helpers.getPrimesList

class SubstringDivisibility: Solution {
	private val primes = getPrimesList(18)

	override val rightSolution = 16695334890L
	override fun solve(): Long{
		val elementarPandigital = "0123456789"

		val possibleCombinations = elementarPandigital.generateAllPermutations()
		val criteriaAttendCombinations = possibleCombinations.filter(::checkCriteria).map { it.toLong() }
		return criteriaAttendCombinations.sum()
	}

	private fun checkCriteria(str: String): Boolean{
		var idx = 1
		var attend = true

		while (attend && idx != 8){
			val compareNum = "${str[idx]}${str[idx + 1]}${str[idx + 2]}".toLong()
			val comparePrime = primes[idx - 1]
			attend = (compareNum % comparePrime) == 0L
			idx++
		}

		return attend
	}
 }