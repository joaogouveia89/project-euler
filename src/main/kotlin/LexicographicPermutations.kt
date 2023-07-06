import base.*
import ext.nextLexicographicPermutation
import ext.toNumber

/**
 * IF WE GET THE NUMBERS START WITH 0 WE HAVE 362880 LEXOGRAPHIC NUMBERS IN THIS INTERVAL AS WE CAN SEE:
 * '0' 9 x 8 x 7 x 6 x 5 x 4 x 3 x 2 x 1 = 362880
 * FOR NUMBERS STARTING WITH 1 WE HAVE MORE 362880 POSSIBILITIES SO WE HAVE 725760 NUMBERS BEWTEEN 0123456789 AND 1987654320
 * FOR NUMBERS STARTING WITH 2 WE HAVE MORE 362880 POSSIBILITIES SO WE HAVE 1088640 POSSIBITIES BETWEEN 0123456789 AND 298765431
 * SO IT IS CLEAR THAT THE NUMBER 1000000 STARTS WITH 2... GOING ON THIS ANALISYS AND REDUCING THE RANGE WE CAN REACH THE RESULT...

 * THIS IS THE HAND WAY I FOUND TO SOLVE, AND THIS ONE IS THE ALGORITHM ONE BASED IN THIS ARCTICLE
 * http://bearcave.com/random_hacks/permute.html
 **/

class LexicographicPermutations: Solution { 
	override val rightSolution = 2783915460L

	private val goalPermutation = 1000000

	override fun solve(): Long {
		var digits = (0..9).toList()

		var currentPermutation = 1

		while (currentPermutation != goalPermutation){
			digits = digits.nextLexicographicPermutation()
			currentPermutation++
		}

		return digits.toNumber()
	}
 }