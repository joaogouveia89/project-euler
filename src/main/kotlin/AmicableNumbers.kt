import base.*
import ext.divisors
import kotlinx.coroutines.*

class AmicableNumbers: Solution {
	private val scope = CoroutineScope(Dispatchers.IO + Job())

	override val rightSolution = 31626L

	override fun solve(): Long = runBlocking {
		val max = 10000
		val divisorsSum = mutableMapOf<Int, Deferred<Int>>()
		var ammicableSum = 0

		(1..max).map {
			divisorsSum[it] = scope.async{
				it.divisors().sum()
			}
		}

		divisorsSum.keys.forEach{
			divisorsSum[it]?.await()
		}

		(1..max).forEach {number ->
			val amicable = divisorsSum[number]?.getCompleted() ?: 0

			if(
				number < amicable &&
				number == divisorsSum[amicable]?.getCompleted()
			){
				ammicableSum += (number + amicable)
			}
		}

		ammicableSum.toLong()
	}
 }