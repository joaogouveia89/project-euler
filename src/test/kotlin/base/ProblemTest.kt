package base

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


abstract class ProblemTest<T> {
    abstract val solution: Solution<T>

    @Test
    fun test(){
        assertEquals(solution.rightSolution, solution.solve())
    }
}