package base

import java.nio.file.Paths

interface Solution {
    fun solve(): Long
    val rightSolution: Long

    fun getLongInput(filename: String) = Paths.get("").toAbsolutePath().toString() + "/longinputs/" + filename
}