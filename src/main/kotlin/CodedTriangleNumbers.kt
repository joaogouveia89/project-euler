import base.*
import ext.alphabetPositionUpperCase
import java.io.File
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class CodedTriangleNumbers: Solution { 
	override val rightSolution = 162L /* ENTER HERE THE SOLUTION RESULT */
	override fun solve(): Long {
		//tn = 0.5 * n * (n+1)
		// tn = 0.5n^2 + 0.5n
		// 0.5n^2 + 0.5n - tn= 0
		// delta = 0.5^2 - 4 * 0.5 * -tn

		var triangleWordsCount = 0L

		val inputFile = getLongInput("coded-triangle-numbers.txt")
		val inputArray = File(inputFile).readLines().first().split(",").map {
			it.removePrefix("\"").removeSuffix("\"")
		}

		inputArray.forEach { word ->

			val tn = word.toCharArray().map {
				it.alphabetPositionUpperCase()
			}.reduce { acc, i -> acc + i }

			val delta = 0.5.pow(2) - 4 * 0.5 * tn.inv()

			val x1 = (-0.5 + sqrt(delta))/(2 * 0.5)
			val x2 = (-0.5 - sqrt(delta))/(2 * 0.5)

			val tn1Test = abs(x1).toInt().let { n->
				0.5 * n * (n+1)
			}.toInt()

			val tn2Test = abs(x2).toInt().let { n->
				0.5 * n * (n+1)
			}.toInt()

			if(tn1Test == tn || tn2Test == tn){
				triangleWordsCount++
			}
		}

		return triangleWordsCount
	}
 }