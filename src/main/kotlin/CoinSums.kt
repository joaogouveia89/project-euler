import base.*

class CoinSums: Solution { 
	override val rightSolution = 73682L

	private val coinValues = listOf(1, 2, 5, 10, 20, 50, 100, 200)
	private val goal = 200

	override fun solve(): Long{
		var waysTo200 = 0L
		var times = IntArray(8){ 0 }
		val coinsValuesSize = coinValues.size - 1

		while(coinValues[coinsValuesSize] * times[coinsValuesSize] <= goal){
			var sum = 0
			for(coinIdx in coinValues.indices){
				sum += (coinValues[coinIdx] * times[coinIdx])
			}
			var idx = 0
			if(sum <= goal){
				if(sum == goal) waysTo200++
				while(times[idx] > goal){
					times[idx] = 0
					idx++
				}
				times[idx]++
			}else{
				while(times[idx] == 0){
					idx++
				}
				times[idx] = 0
				times[idx+1]++
			}
		}

		return waysTo200
	}
 }