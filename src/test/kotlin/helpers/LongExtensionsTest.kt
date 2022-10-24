package helpers

import base.isMultipleOf
import base.isPrime
import org.junit.jupiter.api.Test

class LongExtensionsTest {

    @Test
    fun `is 10 prime`() {
        assert(!10L.isPrime())
    }

    @Test
    fun `is 13 prime`() {
        assert(13L.isPrime())
    }

    @Test
    fun `is 13469 prime`() {
        assert(13469L.isPrime())
    }

    @Test
    fun `is 7191 multiple of 600851475143`() {
        assert(!600851475143L.isMultipleOf(7191L))
    }
}