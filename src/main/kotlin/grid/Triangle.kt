package grid

import ext.toTriangle
import java.util.Collections
import kotlin.math.max

class Triangle(triangleStr: String) {
    private val triangle: List<List<Long>> = triangleStr.toTriangle()

    private val numberOfRows = triangle.size

    private val triangleMatrix = triangle.map {
        it + Collections.nCopies(numberOfRows - it.size, 0)
    }

    private val dp = Array(numberOfRows){ (LongArray(numberOfRows) {-1}).toMutableList() }.toList()

    fun maxPathSum(): Long {
        return maxPathSum(0, 0, numberOfRows, numberOfRows)
    }

    private fun maxPathSum(i: Int, j: Int, row: Int, col: Int): Long{
        if(j == col) return 0L
        if(i == row - 1) return triangleMatrix[i][j]
        if(dp[i][j] != -1L) return dp [i][j]

        dp[i][j] = triangleMatrix[i][j] + max(
            maxPathSum(i + 1, j, row, col),
            maxPathSum(i + 1, j + 1, row, col)
        )

        return dp[i][j]
    }


}