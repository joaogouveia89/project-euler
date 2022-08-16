package base

// used big integer here for the sake of precision
fun Long.pow(exponent: Int): Long = toBigInteger().pow(exponent).toLong()
fun Long.sqrt(): Long = toBigInteger().sqrt().toLong()

fun Long.isOdd() = this % 2L == 1L

fun Long.isMultipleOf(toCheck: Long) = this % toCheck == 0L

fun Long.isPrime(): Boolean{
    val sqrt = this.sqrt() + 1
    for(i in 2L..sqrt){
        if(this % i == 0L){
            return false;
        }
    }
    return true;
}