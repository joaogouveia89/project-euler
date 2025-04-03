import base.Solution
import ext.isOdd

class LongestCollatzSequence : Solution {

    /*
     * This one was a little more challenging due to the chosen caching mechanism.
     * At first I tried to do it using a common list with a data class, which stored a number and the size of the sequence it generated,
     * it turns out that this increased the complexity, due to the search in the list at each iteration, A(n).
     * When changing to map the complexity of this search reduced to A(1) which accelerated the resolution
     */

    private val roofNumber = 1000000L

    private val cache = mutableMapOf<Long, Long>().apply {
        put(1L, 1L)
    }

    override val rightSolution = 837799L

    override fun solve(): Long {

        for (i in 2 until roofNumber) {
            val hasNotBeenCalculated = !cache.containsKey(i)

            var sequence = i
            if (hasNotBeenCalculated) {
                val temporaryList = mutableListOf(i)
                var sequenceCache: Long? = null

                while (sequence != 1L) {
                    sequence = if (sequence.isOdd())
                        (sequence * 3) + 1
                    else
                        sequence / 2

                    sequenceCache = cache[sequence]

                    if (sequenceCache == null)
                        temporaryList.add(sequence)
                    else {
                        sequence = 1L
                    }
                }
                for ((index, temp) in temporaryList.withIndex()) {
                    //Store result in cache
                    cache[temp] = (sequenceCache ?: 0) + temporaryList.size - index
                }
            }
        }

        return cache
            .maxBy { it.value }
            .key
    }
}