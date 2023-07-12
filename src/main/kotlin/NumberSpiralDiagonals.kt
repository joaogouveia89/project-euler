import base.*
import kotlinx.coroutines.*
import kotlin.math.pow

/*
* The diagonals values grows up in a linear way, so I can interpolate the given values to
* know the other points
 */
class NumberSpiralDiagonals: Solution, Arithmetic() {
	override val rightSolution = 669171001L

	private val scope = CoroutineScope(Dispatchers.IO + Job())

	private val size = 500

	override fun solve(): Long = runBlocking {

		val operations = listOf(
			scope.async { sumofInterpolation(listOf(1, 3, 13)) },
			scope.async { sumofInterpolation(listOf(1, 5, 17)) },
			scope.async { sumofInterpolation(listOf(1, 7, 21)) },
			scope.async { sumofInterpolation(listOf(1, 9, 25)) }
		)

		(operations.sumOf {
			it.await()
		} - 3) .toLong()/* -3 because all the sequences has 1 as element, we have to sum just once the number one */
	}
	private fun sumofInterpolation(givenValues: List<Int>): Int{
		val fromValue = givenValues.size
		var sum = givenValues.sum()

		var points = givenValues.mapIndexed { index, value ->
			Pair(index, value)
		}

		for(current in fromValue..size){
			sum += interpolate(points, current)
		}

		return sum
	}
}