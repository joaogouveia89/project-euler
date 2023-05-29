package base

fun String.isPalindrome() = this == this.reversed()

fun String.getSubstring(fromIndex: Int, toIndex: Int) =
    toCharArray()
        .copyOfRange(fromIndex, toIndex)
        .joinToString("")

fun String.toTriangle(): List<List<Long>> =
    split("\n")
        .map {
            it.split(" ")
                .map {
                    it2 -> it2.toLong()
                }
        }