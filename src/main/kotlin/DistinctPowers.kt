import base.*
import java.math.BigInteger
import kotlin.math.pow

class DistinctPowers: Solution { 
	override val rightSolution = 9183L
	private val roof = 100

	override fun solve(): Long{
		val possibilities = mutableListOf<BigInteger>()
		for(a in 2..roof){
			for(b in 2..roof){
				possibilities.add(
					a.toBigInteger().pow(b)
				)
			}
		}

		return possibilities.distinct().size.toLong()
	}
 }