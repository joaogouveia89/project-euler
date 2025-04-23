import base.*
import helpers.getPrimesList

class PrimePermutations: Solution { 
	override val rightSolution = 296962999629L
	override fun solve(): Long{

		var other3ElPa: List<Long>? = null

		val fourDigitPrimeList = getPrimesList(9999).filter { it.toString().length == 4 }

		val permutationsMap = fourDigitPrimeList.groupBy {
			it.toString().toCharArray().map { c -> c.digitToInt().toLong() }.sorted()
		}

		permutationsMap.keys.forEach {
			permutationsMap[it]?.let { list ->
				if(list.size > 2){
					val pa = list.sorted().findPaTriplet()
					if(pa != null && pa.size == 3 && pa != listOf(1487, 4817, 8147))
						other3ElPa = pa
				}
			}
		}

		return other3ElPa?.joinToString("")?.toLong() ?: 0L
	}

	private fun List<Long>.findPaTriplet(): List<Long>? {
		val sortedList = this.sorted()
		for (i in sortedList.indices) {
			for (j in i + 1 until sortedList.size) {
				val a = sortedList[i]
				val b = sortedList[j]
				val diff = b - a
				val c = b + diff
				if (c in sortedList) {
					return listOf(a, b, c)
				}
			}
		}
		return null
	}

}