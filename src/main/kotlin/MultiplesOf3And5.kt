import base.Solution

class MultiplesOf3And5: Solution<Int> {

    companion object{
        const val FLOOR = 3
        const val ROOF = 999
    }

    override val rightSolution: Int = 233168

    override fun solve(): Int {
        var sum = 0
        for (i in FLOOR..ROOF){
            if(i % 3 == 0 || i % 5 == 0){
                sum += i
            }
        }
        return sum
    }
}