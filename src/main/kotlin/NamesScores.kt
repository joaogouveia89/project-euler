import base.*
import ext.alphabetPositionUpperCase
import java.io.File
import java.nio.file.Paths

class NamesScores: Solution { 
	override val rightSolution = 871198282L

	override fun solve(): Long{
		val inputFile = getLongInput("names-scores.txt")

		val inputArray = File(inputFile).readLines().first().replace("\"", "").split(",")

		val inputSorted = inputArray.sorted()

		var finalSum = 0L

		inputSorted.forEachIndexed {index, name ->
			val nameSum = name.sumOf { it.alphabetPositionUpperCase() }
			finalSum += (nameSum * (index + 1))
		}

		return finalSum
	}
 }