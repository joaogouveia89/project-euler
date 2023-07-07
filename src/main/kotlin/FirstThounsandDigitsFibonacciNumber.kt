import base.*
import java.math.BigInteger

class FirstThounsandDigitsFibonacciNumber: Solution { 
	override val rightSolution = 4782L

	private val currentLengthGoal = 1000

	override fun solve(): Long{
		var previous = BigInteger("1")
		var current = BigInteger("1")
		var currentIndex = 2

		while (current.toString().length != currentLengthGoal){
			val temp = current
			current += previous
			previous = temp
			currentIndex++
		}

		return currentIndex.toLong()
	}
 }