import base.*
import kotlinx.coroutines.*

class LargestPrimeFactor : Solution {

    companion object{
        const val GOAL = 600851475143
    }

    override val rightSolution = 6857L

    private val scope = CoroutineScope(Dispatchers.IO + Job())
    private var largestPrimeFactor: Long = 0L

    @Synchronized
    private fun checkAndUpdateLargestPrimeFactor(newValue: Long){
        if(newValue > this.largestPrimeFactor)
            this.largestPrimeFactor = newValue
    }


    @DelicateCoroutinesApi
    override fun solve(): Long {
        // we can safely say that after the number 2 all prime numbers are odds, because the even ones are divisible by 2
        // we can test any number more than the square root rounding to floor
        runBlocking {
            val jobs = mutableListOf<Job>()
            var current = 1L

            while (current.pow(2) < GOAL){
                // important to avoid racing conditions
                current.let {
                    if(it.isOdd() && GOAL.isMultipleOf(it)){
                        jobs.add(scope.launch {
                            if(it.isPrime()){
                                checkAndUpdateLargestPrimeFactor(it)
                            }
                        })
                    }
                }

                current++
            }
            jobs.joinAll()
        }

        return largestPrimeFactor
    }
}