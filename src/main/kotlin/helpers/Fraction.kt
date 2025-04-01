package helpers

import base.Arithmetic
import kotlin.math.abs

data class Fraction(
    val numerator: Long,
    val denominator: Long
): Arithmetic(){
    fun isTrivial() = numerator.toString().contains("0") && denominator.toString().contains("0")

    val value: Double
        get() = numerator.toDouble()/denominator.toDouble()

    operator fun times(f: Fraction): Fraction{
        return Fraction(this.numerator * f.numerator, this.denominator * f.denominator)
    }

    fun removeCommon(): Fraction {
        val numeratorStr = numerator.toString()
        val denominatorStr = denominator.toString()
        if (numeratorStr.length != 2 || denominatorStr.length != 2) return this

        val commonChars = numeratorStr.toList().intersect(denominatorStr.toList().toSet())
        if (commonChars.isEmpty()) return this

        var newNumerator = numeratorStr
        var newDenominator = denominatorStr

        for (char in commonChars) {
            newNumerator = newNumerator.replaceFirst(char.toString(), "")
            newDenominator = newDenominator.replaceFirst(char.toString(), "")
        }

        return Fraction(newNumerator.ifEmpty { "0" }.toLong(), newDenominator.ifEmpty { "0" }.toLong())
    }

    fun simplify(): Fraction {
        val gcdValue = mdc(abs(numerator), abs(denominator))
        return Fraction(numerator / gcdValue, denominator / gcdValue)
    }
}