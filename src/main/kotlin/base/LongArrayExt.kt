package base

fun LongArray.mulAll() = this.reduce{acc, i -> acc * i }