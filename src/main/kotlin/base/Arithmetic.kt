package base

open class Arithmetic {
    fun mdc(a: Long, b: Long): Long =
        if(b == 0L)  a;
        else mdc(b, a % b);

    // https://www.geeksforgeeks.org/multiplicative-order/
    fun multiplicativeOrder(a: Long, n: Long): Long{
        var result = 1L
        var k = 1L
        if(mdc(a, n) == 1L){
            while (k < n)
            {
                result = (result * a) % n;
                if (result  == 1L)
                    return k
                k++;
            }
        }
        return -1;
    }
}