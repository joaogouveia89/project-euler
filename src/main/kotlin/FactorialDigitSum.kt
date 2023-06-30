import base.*

class FactorialDigitSum: Solution { 
	override val rightSolution = 648L
	override fun solve(): Long{
		var factorial = 1.toBigInteger()

		(100 downTo 1).forEach {
			factorial *= it.toBigInteger()
		}

		return factorial.toString().sumOf {
			it.digitToInt()
		}.toLong()
	}
 }