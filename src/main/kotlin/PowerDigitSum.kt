import base.*
import stringnumber.StringNumber

class PowerDigitSum: Solution {
	override val rightSolution = 1366L

	override fun solve(): Long =
		StringNumber.pow(2, 1000)
			.digitsSum()
			.toLong()
 }