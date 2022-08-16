import base.Solution
import base.isPalindrome

class LargestPalindromeProduct: Solution {

    companion object{
        const val FLOOR = 100
        const val ROOF = 999
    }

    override val rightSolution = 906609

    private var mul = 0L

    private var largestPalindromeProduct: Long = 0L

    override fun solve(): Int {
        for(a in FLOOR..ROOF){
            for(b in FLOOR..ROOF){
                mul = (a * b).toLong()
                if(mul.toString().isPalindrome() && mul > largestPalindromeProduct){
                    largestPalindromeProduct = mul
                }
            }
        }

        return largestPalindromeProduct.toInt()
    }
}