import base.*
import helpers.Fraction

class DigitCancellingFractions: Solution { 
	override val rightSolution = 100L
	override fun solve(): Long {
		val possibleFractions = (1L..99L).flatMap {
			(1 until it).map { it2 ->
				Fraction(it2, it)
			}
		}

		return possibleFractions
			.filter { !it.isTrivial() }
			.mapNotNull { fraction ->
				val newFraction = fraction.removeCommon()
				if (fraction != newFraction && fraction.value == newFraction.value) fraction else null
			}
			.reduce { acc, fraction ->
				acc * fraction
			}
			.simplify()
			.denominator
	}
 }