package helpers

import ext.isPalindrome
import org.junit.jupiter.api.Test

class StringExtensionsTest {

    @Test
    fun `is ARARA palindrome`() {
        assert("ARARA".isPalindrome())
    }

    @Test
    fun `is MACARRAO palindrome`() {
        assert(!"MACARRAO".isPalindrome())
    }
}