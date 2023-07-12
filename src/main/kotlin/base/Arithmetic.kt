package base

open class Arithmetic {
    fun mdc(a: Long, b: Long): Long =
        if(b == 0L)  a;
        else mdc(b, a % b);


    // Thanks to https://www.geeksforgeeks.org/lagranges-interpolation/
    fun interpolate(points: List<Pair<Int, Int>>, yn: Int): Int{
        val n = points.size
        var result = 0.0 // Initialize result
        for (i in 0 until n) {
            // Compute individual terms of above formula
            var term: Double = points[i].second.toDouble()
            for (j in 0 until n) {
                if (j != i) term = term * (yn - points[j].first) / (points[i].first - points[j].first)
            }

            // Add current term to result
            result += term
        }
        return result.toInt()
    }

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