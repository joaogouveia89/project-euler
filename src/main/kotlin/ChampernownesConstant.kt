import base.*

class ChampernownesConstant: Solution { 
	override val rightSolution = 210L
	override fun solve(): Long{
		var currentSize = 0L
		var currentNum = 1L
		val finalStr = StringBuilder()

		while (currentSize < 1000000){
			finalStr.append(currentNum.toString())
			currentSize += currentNum.toString().length
			currentNum++
		}

		return finalStr[0].digitToInt().toLong() *
				finalStr[9].digitToInt().toLong() *
				finalStr[99].digitToInt().toLong() *
				finalStr[999].digitToInt().toLong() *
				finalStr[9999].digitToInt().toLong() *
				finalStr[99999].digitToInt().toLong() *
				finalStr[999999].digitToInt().toLong()
	}
 }