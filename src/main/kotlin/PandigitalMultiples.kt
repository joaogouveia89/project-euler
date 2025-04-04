import base.*

class PandigitalMultiples: Solution { 
	override val rightSolution = 932718654L

	override fun solve(): Long{
		var greater = 0L
		/* for nMax = 10000 and nMax * 1 has 5 digits, and nMax * 2 will pass 9 digits */
		for (currentNum in 2..10000){
			var currentMult = 1
			var currentStr = ""
			while (currentStr.length < 9 && currentStr.toList().sorted().joinToString("") != "123456789"){
				val result = currentNum * currentMult
				currentStr += result.toString()
				currentMult++
			}
			if( currentStr.toList().sorted().joinToString("") == "123456789"){
				greater = currentStr.toLong()
			}
		}


		return greater
	}
 }