package ext

import java.util.Collections

// thanks to https://iq.opengenus.org/lexicographical-next-permutation/
fun List<Int>.nextLexicographicPermutation(): List<Int>{
    val list = mutableListOf<Int>().also{
        it.addAll(this)
    }

    var pivot = -1
    var currentPosition = size - 1

    while (currentPosition > 0){
        if(list[currentPosition - 1] < list[currentPosition]){
            pivot = currentPosition - 1
            break
        }
        currentPosition--
    }

    if(pivot == -1) return this

    var rightMostSuccessor = pivot + 1
    currentPosition = pivot + 1

    while (currentPosition < size){
        if(list[currentPosition] >= list[pivot] && list[rightMostSuccessor] - list[pivot] >= list[currentPosition] - list[pivot]){
            rightMostSuccessor = currentPosition
        }
        currentPosition++
    }

    Collections.swap(list, pivot, rightMostSuccessor)

    val suffix = list.subList(pivot + 1, size)
    suffix.reverse()

    return list.subList(0, pivot + 1).also {
        it.addAll(suffix)
    }
}

fun List<Int>.toNumber(): Long{
    var result = 0L
    forEach {
        result = (result * 10) + it
    }
    return result
}