package ext

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

fun String.generateAllPermutations(): List<String>{
    val chars = this.toCharArray()
    val n = chars.size
    val result = mutableListOf<String>()
    val indexes = IntArray(n) { 0 }  // Array auxiliar para controlar trocas
    result.add(String(chars))

    var i = 0
    while (i < n) {
        if (indexes[i] < i) {
            val swapIndex = if (i % 2 == 0) 0 else indexes[i]
            chars.swap(swapIndex, i)
            result.add(String(chars))
            indexes[i]++
            i = 0
        } else {
            indexes[i] = 0
            i++
        }
    }
    return result
}
