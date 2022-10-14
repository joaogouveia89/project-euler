package grid

enum class RangeDirection: RangeValidation {
    RIGHT{
        override fun isValid(gridWidth: Int, gridHeight: Int, fromLine: Int, fromColumn: Int, rangeSize: Int): Boolean =
            fromColumn + rangeSize < gridWidth

    },
    DOWN{
        override fun isValid(gridWidth: Int, gridHeight: Int, fromLine: Int, fromColumn: Int, rangeSize: Int): Boolean {
            TODO("Not yet implemented")
        }

    },
    DIAGONAL_DOWN{
        override fun isValid(gridWidth: Int, gridHeight: Int, fromLine: Int, fromColumn: Int, rangeSize: Int): Boolean {
            TODO("Not yet implemented")
        }

    },
    DIAGONAL_UP{
        override fun isValid(gridWidth: Int, gridHeight: Int, fromLine: Int, fromColumn: Int, rangeSize: Int): Boolean {
            TODO("Not yet implemented")
        }

    }
}