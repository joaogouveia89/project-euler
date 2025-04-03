package helpers

import kotlin.math.sqrt

fun getPrimesList(roof: Long): List<Long>{
    val limit = sqrt(roof.toDouble()).toInt()
    var checkingList = (2L..roof).toList()
    var currentValue = checkingList[0]
    while (currentValue <= limit){
        checkingList = checkingList.filter {
            it == currentValue || it % currentValue != 0L
        }
        currentValue++
    }

    return checkingList
}