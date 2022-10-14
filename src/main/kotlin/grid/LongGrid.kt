package grid

class LongGrid(private val lines: Int, private val columns: Int, private val elements: LongArray){

    companion object{
        fun fromText(gridStr: String, numbersSeparatorCharacter: Char = ' '): LongGrid{
            val splintedGrid = gridStr.split("\n").map { it.split(numbersSeparatorCharacter) }
            return LongGrid(
                splintedGrid.count(),
                splintedGrid.first().size,
                splintedGrid.flatten().map { it.toLong() }.toLongArray()
            )
        }
    }

    fun get(line: Int, column: Int) = elements[lines * line + column]

    private fun isValidRangeRight( from: Int, rangeSize: Int) =
        from + rangeSize < columns

    fun getRange(fromLine: Int,
                 fromColumn: Int,
                 rangeSize: Int,
                 rangeDirection: RangeDirection = RangeDirection.RIGHT): LongArray =
        if (!rangeDirection.isValid(columns, lines, fromLine, fromColumn, rangeSize)) longArrayOf()
        else
            when(rangeDirection){

                RangeDirection.RIGHT -> elements.copyOfRange(lines * fromLine + fromColumn, lines * fromLine + fromColumn + rangeSize + 1)
                // an = a1 + (n - 1) * r
                RangeDirection.DOWN -> (1 until rangeSize + 1).map { elements[(lines * fromLine + fromColumn) + (it - 1) * columns] }.toLongArray()
                RangeDirection.DIAGONAL_DOWN ->  (1 until rangeSize + 1).map { elements[(lines * fromLine + fromColumn) + (it - 1) * (columns + 1)] }.toLongArray()
                RangeDirection.DIAGONAL_UP -> (1 until rangeSize + 1).map { elements[(lines * fromLine + fromColumn) + (it - 1) * (columns - 1) * -1] }.toLongArray()
            }

}