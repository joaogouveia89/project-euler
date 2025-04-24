import base.*
import helpers.getPrimesList

class ConsecutivePrimeSum: Solution { 
	override val rightSolution = 997651L
	override fun solve(): Long{
		val limit = 1000000L
		val primeList = getPrimesList(limit)
		val primeSet = primeList.toSet() // for O(1) search
		var response = 0L
		var maxConsecutive = 0
		val primeListSize = primeList.size
		for (startIndex in primeList.indices) {
			var currentSum = 0L
			for(endIndex in (startIndex + 1) until primeListSize){
				currentSum += primeList[endIndex]
				if(currentSum > limit) break
				val currentLength = endIndex - startIndex
				if(currentSum in primeSet && currentLength > maxConsecutive){
					maxConsecutive = currentLength
					response = currentSum
				}
			}
		}

		return response
	}

}