import base.*
import kotlinx.coroutines.*

class SummationOfPrimes: Solution {
	companion object{
		const val ROOF = 2000000L
		// in my tests I realized it is faster to have fewer coroutines with a big range, instead of several coroutines with smaller ranges
		const val COROUTINES_RANGE_RESPONSIBILITY = 250000L
	}

	private val scope = CoroutineScope(Dispatchers.IO + Job())

	override val rightSolution = 142913828922L

	private suspend fun sumOfPrimes(from: Long, to: Long) = withContext(Dispatchers.IO){
		var sum = 0L
		for(number in from..to){
			if(number.isPrime()){
				sum += number
			}
		}
		sum
	}

	override fun solve() = runBlocking {
		val coroutinesResults = mutableListOf<Deferred<Long>>()
		for(number in 0 until ROOF step COROUTINES_RANGE_RESPONSIBILITY){
			coroutinesResults.add( scope.async { sumOfPrimes(number, number + COROUTINES_RANGE_RESPONSIBILITY - 1) } )
		}
		coroutinesResults.awaitAll().sum()
	}
}