package base

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


abstract class ProblemTest {
    abstract val solution: Solution

    @Test
    fun test() {
        assertEquals(solution.rightSolution, solution.solve())
    }
}