import base.*
import helpers.getPrimesList
import kotlin.math.sqrt

class GoldbachsOtherConjecture: Solution { 
	override val rightSolution = 5777L
	override fun solve(): Long{
		// n = p + 2 × k²
		var againstProof = 0L
		val primes = getPrimesList(10000)
		val oddsNonPrimes = (0..10000).filter { it != 1 && (it % 2 != 0) && it.toLong() !in primes }

		mainLoop@ for (odd in oddsNonPrimes){
			val checkPrimes = primes.filter { it < odd }
			var found = false
			checkPrimes.forEach { p ->
				val kSquared = (odd - p) / 2
				val kRoot = sqrt(kSquared.toDouble()).toInt()
				if (kRoot * kRoot == kSquared.toInt()) {
					found = true
					return@forEach
				}
			}
			if(!found){
				againstProof = odd.toLong()
				break@mainLoop
			}
		}

		return againstProof
	}
 }