package grid

enum class RangeDirection : RangeValidation {
    RIGHT {
        override fun isValid(gridWidth: Int, gridHeight: Int, fromLine: Int, fromColumn: Int, rangeSize: Int): Boolean =
            fromColumn + rangeSize <= gridWidth
    },
    DOWN {
        override fun isValid(gridWidth: Int, gridHeight: Int, fromLine: Int, fromColumn: Int, rangeSize: Int): Boolean =
            fromLine + rangeSize <= gridHeight
    },
    DIAGONAL_DOWN {
        override fun isValid(gridWidth: Int, gridHeight: Int, fromLine: Int, fromColumn: Int, rangeSize: Int): Boolean =
            fromColumn + rangeSize <= gridWidth && fromLine + rangeSize <= gridHeight
    },
    DIAGONAL_UP {
        override fun isValid(gridWidth: Int, gridHeight: Int, fromLine: Int, fromColumn: Int, rangeSize: Int): Boolean =
            fromColumn + rangeSize <= gridWidth && fromLine - rangeSize >= 0
    };

    companion object {
        val directions = RangeDirection.values()
    }
}