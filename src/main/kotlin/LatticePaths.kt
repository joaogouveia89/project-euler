import base.Solution

class LatticePaths : Solution {
    /*
    *   See the draft for this problem in drafts/lattice_paths.jpg
     */
    companion object {
        const val GRID_SIZE = 20
    }

    override val rightSolution = 137846528820L
    override fun solve(): Long {

        var lastRow = List(GRID_SIZE) { 1L }
        var interaction = 1

        while (interaction != GRID_SIZE + 1) {
            var currentElement = 1L

            val currentRow = lastRow.map {
                currentElement += it
                currentElement
            }

            lastRow = currentRow
            interaction++
        }

        return lastRow.last()
    }
}