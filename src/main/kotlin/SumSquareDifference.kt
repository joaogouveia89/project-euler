import base.*
import kotlin.math.pow

class SumSquareDifference: Solution {

	override val rightSolution = 25164150L

	override fun solve(): Long {
		// more elegant way in my mind, but it would be more efficient if I iterate over the range once
		val sumOfSquares: Int = (0..100).sumOf { it.toDouble().pow(2.0).toInt() }
		val squareOfSum: Int = (0..100).sum().toDouble().pow(2.0).toInt()
		return (squareOfSum - sumOfSquares).toLong()
	}
 }