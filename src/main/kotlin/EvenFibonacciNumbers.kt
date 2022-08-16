import base.Solution
import base.isEven

class EvenFibonacciNumbers: Solution<Int> {

    companion object{
        const val ROOF = 4000000
    }

    override val rightSolution = 4613732

    override fun solve(): Int {
        var currentElement = 2
        var lastElement = 1

        var sumEvens = 0

        while (currentElement < ROOF){
            if(currentElement.isEven()){
                sumEvens += currentElement
            }

            // maybe there's a better way
            currentElement = currentElement.let {
                val sum = currentElement + lastElement
                lastElement = it
                sum
            }

        }

        return sumEvens
    }
}