package base

enum class NumberClassification{
    ABUNDANT, PERFECT, DEFICIENT
}

fun Int.isEven() = this % 2 == 0

fun Int.divisors(): List<Int>{
    val max = this/2
    return if(this == 1)
        listOf(1)
    else (1..max)
        .filter {this % it == 0  }
}

fun Int.classification(): NumberClassification{
    val divisorsSum = divisors().sum()
    return if(divisorsSum > this)
        NumberClassification.ABUNDANT
    else if(divisorsSum < this)
        NumberClassification.DEFICIENT
    else
        NumberClassification.PERFECT
}