package base

fun LongArray.mulAll() = this.let {
    if (it.isEmpty()) 0L
    else reduce { acc, i -> acc * i }
}