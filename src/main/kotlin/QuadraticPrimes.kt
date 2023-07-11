import base.*

class QuadraticPrimes: Solution { 
	override val rightSolution = -59231L
	private val max = 1000L

	private fun numberOfConsecutivePrimes(a: Long, b: Long): Long{
		var counter = 0
		var n = 0
		var isPrime = true
		while (isPrime) {
			val equationResult = (n * n + a * n + b)
			isPrime =
				if(equationResult < 0)
					false
				else
					(n * n + a * n + b).isPrime()
			n++
			if (isPrime) counter++
		}
		return counter.toLong()
	}

	override fun solve(): Long{
		var nocp = 0L
		var greattest = 1L
		var product = 0L

		for(a in 0L until max)
			for(b in 0..max){
				nocp = numberOfConsecutivePrimes(a, b);
				if(nocp > greattest){
					greattest = nocp;
					product = a * b;
				}
				nocp = numberOfConsecutivePrimes(a*-1, b);
				if(nocp > greattest){
					greattest = nocp;
					product = -a * b;
				}
				nocp = numberOfConsecutivePrimes(a, b * -1);
				if(nocp > greattest){
					greattest = nocp;
					product = a * -b;
				}
				nocp = numberOfConsecutivePrimes(a * -1, b * -1);
				if(nocp > greattest){
					greattest = nocp;
					product = -a * -b;
				}
			}

		return product
	}
 }