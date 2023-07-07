import base.*

/*
	A fraction in lowest terms with a prime denominator other than 2 or 5 (i.e. coprime to 10)
	always produces a repeating decimal. The length of the repetend (period of the repeating decimal
	segment) of 1/p is equal to the order of 10 modulo p. If 10 is a primitive root modulo p, the
	repetend length is equal to p − 1; if not, the repetend length is a factor of p − 1. This result
	can be deduced from Fermat's little theorem, which states that 10p−1 ≡ 1 (mod p).
	font: https://en.wikipedia.org/wiki/Repeating_decimal
 */
class ReciprocalCycles: Solution, Arithmetic() {
	override val rightSolution = 983L
	private val roof = 1000L

	override fun solve(): Long{
		var greatest = 0L
		var greatestN = 0L

		for(n in 6L until roof){
			if(n.isPrime()){
				val o = multiplicativeOrder(10, n);
				if(o > greatest){
					greatestN = n;
					greatest = o;
				}
			}
		}


		return greatestN
	}
 }