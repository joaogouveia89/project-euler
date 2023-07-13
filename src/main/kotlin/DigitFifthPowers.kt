import base.*
import kotlin.math.pow

// boundaring as https://www.xarg.org/puzzle/project-euler/problem-30/
class DigitFifthPowers: Solution { 
	override val rightSolution = 443839L

	private val lowerLimit = 10
	private val upperLimit = 354294

	override fun solve(): Long{
		var result = 0L
		for(i in lowerLimit..upperLimit){
			if(i.figuresToList().sumOf { it.toDouble().pow(5).toInt() } == i){
				result += i
			}
		}
		return result
	}
 }