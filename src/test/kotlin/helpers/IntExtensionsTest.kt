package helpers

import base.divisors
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IntExtensionsTest {

    @Test
    fun `220 divisors list `() {
        val divisors = 220.divisors()
        val result = listOf(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110)
        assertEquals(divisors, result)
    }
}