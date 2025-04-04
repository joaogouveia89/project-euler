import base.*
import helpers.getPrimesList

class TruncatablePrimes: Solution { 
	override val rightSolution = 748317L
	private val primesList = getPrimesList(1000000L).toSet()

	override fun solve(): Long{
		val truncatable = mutableListOf<Long>()
		primesList.forEach {
			if(it.toString().length > 1){
				val number = it.toString()
				val isTruncable = isTruncatable(number)
				if(isTruncable){
					truncatable.add(it)
				}
			}
		}
		return truncatable.sum()
	}

	private fun isTruncatable(number: String): Boolean{
		var isTruncatable = true
		var currentNumberLeftToRight = number
		var currentNumberRightToLeft = number
		while (currentNumberLeftToRight.isNotEmpty() && currentNumberRightToLeft.isNotEmpty() && isTruncatable){
			currentNumberLeftToRight = currentNumberLeftToRight.drop(1)
			currentNumberRightToLeft = currentNumberRightToLeft.dropLast(1)
			if(
				currentNumberLeftToRight.isNotEmpty() &&
				currentNumberLeftToRight.toLong() !in primesList ||
				currentNumberRightToLeft.isNotEmpty() &&
				currentNumberRightToLeft.toLong() !in primesList
			) isTruncatable = false
		}

		return isTruncatable
	}
 }