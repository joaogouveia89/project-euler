package base

// used big integer here for the sake of precision
fun Long.pow(exponent: Int): Long = toBigInteger().pow(exponent).toLong()
fun Long.sqrt(): Long = toBigInteger().sqrt().toLong()

fun Long.isOdd() = this % 2L == 1L

fun Long.isMultipleOf(toCheck: Long) = this % toCheck == 0L

fun Long.isPrime(): Boolean {
    if (this == 2L) return true
    // by definition 0 and 1 are not primes
    if (this == 0L || this == 1L || this % 2L == 0L) return false

    val sqrt = this.sqrt() + 1
    for (i in 2L..sqrt) {
        if (this % i == 0L) {
            return false
        }
    }
    return true
}

// thanks to https://stackoverflow.com/a/5406805
fun Long.nUmOfDivisors(): Long{
    if(this == 1L) return this

    var limit = this
    var numOfDivisors = 0L
    var i = 1L

    /* I tried to use for(i in 1 until limit) here, but it doesn't work, as in the tests it seems that the limit variable is not being updated
     * as it supposed to do, to avoid a bug in the algorithm.
     */
    while(i < limit){
        if(this % i == 0L){
            limit = this / i
            if(limit != i)  numOfDivisors++
            numOfDivisors++
        }
        i++
    }

    return numOfDivisors
}