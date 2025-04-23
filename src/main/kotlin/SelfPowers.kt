import base.*
import java.math.BigInteger

class SelfPowers: Solution { 
	override val rightSolution = 9110846700L
	override fun solve(): Long{
		var total = BigInteger.ZERO

		for(n in 1..1000){
			val bi = BigInteger.valueOf(n.toLong())
			total += bi.pow(n)
		}
		return total.toString().takeLast(10).toLong()
	}
 }