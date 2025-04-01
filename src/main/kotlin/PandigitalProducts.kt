import base.*
import ext.generateAllPermutations

private const val GOAL = "123456789"

class PandigitalProducts: Solution {

	private val checked = mutableSetOf<Long>()

	// a and b cant be at the same time 2 digit numbers, because the biggest multiplication between 2 numbers is 98 * 76 = 7448 which in the end has 8 digits
	override val rightSolution = 45228L

	override fun solve(): Long{
		val permutations = "123456789".generateAllPermutations()

		return permutations.sumOf {
			evaluatePermutationPart(
				a = it.substring(0, 3).toLong(),
				b = it.substring(3, 5).toLong()
			)+ evaluatePermutationPart(
				a = it.substring(4, 5).toLong(),
				b = it.substring(0, 4).toLong()
			)
		}

	}

	private fun evaluatePermutationPart(a: Long, b: Long): Long{
		val mul = a * b
		if(!checked.contains(mul) && !checked.contains(mul) ){
			val finalStr = (a.toString() + b.toString() + mul.toString()).toCharArray().sorted().joinToString("")
			if(finalStr == GOAL){
				checked.add((mul))
				return mul
			}
		}
		return 0L
	}
 }