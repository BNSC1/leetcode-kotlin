class Solution(w: IntArray) {
    val weights = mutableListOf<Int>()
    var total = 0
    init {
        w.forEach {
            total += it
            weights.add(total) //creating a list with weight "ranges"
        }
    }

    fun pickIndex(): Int {
        val rand = kotlin.random.Random.nextInt(1..total)
        weights.forEachIndexed { i, weight -> //check what range the random number falls in
            if (rand <= weight) {
                return i
            }
        }
        return 0 //fodder return
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(w)
 * var param_1 = obj.pickIndex()
 */