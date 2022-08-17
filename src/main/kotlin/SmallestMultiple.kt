import base.*

class SmallestMultiple: Solution {
	companion object{
		const val FLOOR = 2520
	}

	override val rightSolution = 232792560

	override fun solve(): Int {
		var found = false
		var testing = FLOOR

		while (!found){
			for(i in 1..20){
				if(testing % i != 0) break
				found = i == 20
			}
			//numbers which don't end in 0 will never be divisible for 10, so I skip them
			if(!found) testing += 10
		}
		return testing
	}
 }