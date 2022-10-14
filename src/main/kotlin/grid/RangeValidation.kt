package grid

interface RangeValidation {
    fun isValid(gridWidth: Int, gridHeight: Int, fromLine: Int, fromColumn: Int, rangeSize: Int): Boolean
}