import base.*

class IntegerRightTriangles: Solution { 
	override val rightSolution = 840L
	override fun solve(): Long{
		var solutions = 0
		var pMaximized = 0L
		for(p in 12..1000 step 2){
			var solutionsForP = 0
			for(a in 1..(p/3)){
				for(b in a..((p - a)/2)){
					val c = p - a - b
					if(a * a + b * b == c * c){
						solutionsForP++
					}
				}
			}
			if(solutionsForP > solutions){
				solutions = solutionsForP
				pMaximized = p.toLong()
			}
		}
		return pMaximized
	}
 }