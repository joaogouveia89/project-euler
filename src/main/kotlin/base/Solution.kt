package base

interface Solution<T> {
    fun solve(): T
    val rightSolution: T
}