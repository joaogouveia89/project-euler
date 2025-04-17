import base.*
import kotlin.math.abs

class PentagonNumbers: Solution {
	private val pentagonNumbers = mutableListOf(1,5,12,22,35,51,70,92,117,145)

	override val rightSolution = 5482660L

	override fun solve(): Long{

		var currentIndex = 0
		var diff = 0

		var isPentagon = false

		while (!isPentagon){
			var max = pentagonNumbers.last()
			val currentVerifier = pentagonNumbers[currentIndex]
			for(idx in (currentIndex + 1) until  pentagonNumbers.size){
				val sum = currentVerifier + pentagonNumbers[idx]
				diff = abs(currentVerifier - pentagonNumbers[idx])
				if(sum > max){
					var n = pentagonNumbers.size + 1
					while (sum > max){
						val pn = (n * (3 * n - 1)) / 2
						max = pn
						pentagonNumbers.add(pn)
						n++
					}
				}
				if(isPentagonal(sum) && isPentagonal(diff)){
					isPentagon = true
					break
				}
			}
			currentIndex++
		}
		return diff.toLong()
	}

	private fun isPentagonal(x: Int): Boolean {
		val n = (1 + kotlin.math.sqrt(1 + 24.0 * x)) / 6
		return n == n.toInt().toDouble()
	}
 }