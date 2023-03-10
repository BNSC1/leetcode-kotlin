class Solution {
    fun maximalSquare(m: Array<CharArray>): Int {
        val rows = m.size
        val cols = m[0].size
        val cache = HashMap<Pair<Int,Int>,Int>() //coordinate : max length

        fun find(r: Int, c: Int): Int {
            if (r >= rows || c >= cols) return 0 //don't compute if it is out of bounds
            val coord = Pair(r, c)
            if (coord !in cache) { //if the coordinate is not in cache
                val right = find(r+1, c)
                val down = find(r, c+1)
                val diag = find(r+1, c+1) //do compute for 3 different direction

                cache[coord] = if (m[r][c] == '1') { //cache this coordinate, if it has value 1
                    1 + min(right, down, diag) //it has at least the length or 1, plus the minimum length of its neighbors
                } else 0 //cannot form a square if it has value 0
            }
            return cache[coord]!!
        }
        find(0, 0) //start computation at top-left
        val maxLength = cache.values.max()!! //take the max length in the cache
        return maxLength * maxLength //length * length = area
    }
    fun min(n1: Int, n2: Int, n3: Int) = Math.min(n1, Math.min(n2, n3))
}