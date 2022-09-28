import base.*
import kotlinx.coroutines.*

class LargestProductInASeries(
    private val sequenceChecking: Int
) : Solution {

    private val scope = CoroutineScope(Dispatchers.IO + Job())

    override val rightSolution = 23514624000

    // transforming all the array members to int to facilitate the operations
    private val sequence = arrayOf(
        "73167176531330624919225119674426574742355349194934".toCharArray(),
        "96983520312774506326239578318016984801869478851843".toCharArray(),
        "85861560789112949495459501737958331952853208805511".toCharArray(),
        "12540698747158523863050715693290963295227443043557".toCharArray(),
        "66896648950445244523161731856403098711121722383113".toCharArray(),
        "62229893423380308135336276614282806444486645238749".toCharArray(),
        "30358907296290491560440772390713810515859307960866".toCharArray(),
        "70172427121883998797908792274921901699720888093776".toCharArray(),
        "65727333001053367881220235421809751254540594752243".toCharArray(),
        "52584907711670556013604839586446706324415722155397".toCharArray(),
        "53697817977846174064955149290862569321978468622482".toCharArray(),
        "83972241375657056057490261407972968652414535100474".toCharArray(),
        "82166370484403199890008895243450658541227588666881".toCharArray(),
        "16427171479924442928230863465674813919123162824586".toCharArray(),
        "17866458359124566529476545682848912883142607690042".toCharArray(),
        "24219022671055626321111109370544217506941658960408".toCharArray(),
        "07198403850962455444362981230987879927244284909188".toCharArray(),
        "84580156166097919133875499200524063689912560717606".toCharArray(),
        "05886116467109405077541002256983155200055935729725".toCharArray(),
        "71636269561882670428252483600823257530420752963450".toCharArray(),
    ).map { it.map { charInt -> charInt.digitToInt() } }
        .flatten()
        .map { it.toLong() }
        .toLongArray()

	private val sequenceSize = sequence.size

    private suspend fun mullFrom(index: Int) = withContext(Dispatchers.IO) {
        if (index + sequenceChecking >= sequenceSize) 0L
        else sequence
            .copyOfRange(index, index + sequenceChecking)
            .mulAll()
    }
    override fun solve() = runBlocking {
        val coroutines = mutableListOf<Deferred<Long>>()
        sequence.forEachIndexed { index, _ ->
			coroutines.add(scope.async { mullFrom(index) })
        }
        coroutines.awaitAll().max()
    }
}