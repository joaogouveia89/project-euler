package stringnumber

class StringNumber(val number: String) {

    companion object {
        fun pow(base: Int, power: Int): StringNumber {
            var result = StringNumber(base.toString())

            for (mul in 2..power) {
                result *= base
            }

            return result
        }
    }

    operator fun plus(other: StringNumber): StringNumber {
        val top = if (other > this) other else this
        val under = if (top == this) other else this

        val topSize = top.number.length - 1
        val underSize = under.number.length - 1

        var idx = 0
        var remain = 0

        var result = ""

        while (topSize - idx >= 0) {
            val topDigit = top.number[topSize - idx].digitToInt()
            val underDigit = if (underSize - idx >= 0) under.number[underSize - idx].digitToInt() else 0

            val sum = topDigit + underDigit + remain
            remain = if (sum > 9) (sum / 10) else 0

            result = if (idx >= topSize)
                sum.toString() + result
            else
                (sum % 10).toString() + result

            idx++
        }

        return StringNumber(result)
    }

    operator fun times(ratio: Int): StringNumber {
        var current = StringNumber(number)
        val base = StringNumber(number)

        for (i in 1 until ratio) {
            current += base
        }

        return current
    }

    fun digitsSum() = number.sumOf { it.digitToInt() }

    @Suppress("KotlinConstantConditions")
    operator fun compareTo(other: StringNumber): Int {
        val thisFiltered = number.trimStart('0')
        val otherFiltered = other.number.trimStart('0')

        if (thisFiltered.length > otherFiltered.length) return 1
        else if (otherFiltered.length > thisFiltered.length) return -1

        var result = 0

        var idx = 0

        while (idx < thisFiltered.length && result == 0) {
            if (thisFiltered[idx].digitToInt() > otherFiltered[idx].digitToInt()) result = 1
            else if (thisFiltered[idx].digitToInt() < otherFiltered[idx].digitToInt()) result = -1
            idx++
        }

        return result
    }

}