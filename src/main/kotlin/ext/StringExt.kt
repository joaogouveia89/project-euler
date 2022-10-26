package base

fun String.isPalindrome() = this == this.reversed()

fun String.getSubstring(fromIndex: Int, toIndex: Int) =
    toCharArray()
        .copyOfRange(fromIndex, toIndex)
        .joinToString("")