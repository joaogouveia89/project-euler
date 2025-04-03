import base.*
import ext.NumberClassification
import ext.classification

class NonAbundantSums: Solution { 
	override val rightSolution = 4179871L
	private val min = 12 // 12 is the smallest abundant number
	private val max = 28123 //By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers

	override fun solve(): Long{

		val abundantNumbers = (min..max).filter {
			it.classification() == NumberClassification.ABUNDANT
		}

		val isAbundantSum = BooleanArray(max + 1) { false }

		abundantNumbers.forEach {i1 ->
			abundantNumbers.forEach {i2 ->
				if((i1 + i2 <= max)){
					isAbundantSum[i1 + i2] = true
				}
			}
		}

		return isAbundantSum.mapIndexed{ index, value ->
			if(!value) index
			else 0
		}.sum().toLong()
	}
 }