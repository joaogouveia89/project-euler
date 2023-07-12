import base.*
import kotlinx.coroutines.*
import kotlin.math.pow

/* Interpolating the values on the diagonals I got these equations
* 4 x^2 - 10 x + 7
* 4 x^2 - 8 x + 5
* 4 x^2 - 6 x + 3
* 4 x^2 - 4 x + 1
 */
class NumberSpiralDiagonals: Solution { 
	override val rightSolution = 669171001L

	private val scope = CoroutineScope(Dispatchers.IO + Job())

	private val size = 501

	override fun solve(): Long = runBlocking {

		val operations = listOf(
			scope.async { sumOfInterpolation(10,7) },
			scope.async { sumOfInterpolation(8,5) },
			scope.async { sumOfInterpolation(6,3) },
			scope.async { sumOfInterpolation(4,1) }
		)

		(operations.sumOf {
			it.await()
		} - 3) .toLong()/* -3 because all the sequences has 1 as element, we have to sum just once the number one */
	}

	private fun sumOfInterpolation(b: Int, c: Int) =
		(1..size).sumOf {
			((4 * it.toDouble().pow(2)) - b * it + c).toInt()
		}
}