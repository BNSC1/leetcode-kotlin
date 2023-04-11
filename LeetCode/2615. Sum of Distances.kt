class Solution {
    fun distance(nums: IntArray): LongArray {
        val map = HashMap<Int, MutableList<Int>>() //val: indexes
        nums.forEachIndexed { i, n ->
            map[n] = map[n]?.apply {add(i)} ?: mutableListOf(i)
        }

        val res = LongArray(nums.size)
        map.forEach { (n, indexes) ->
            var sum = 0L
            for (i in 0 until indexes.size) {
                sum += indexes[i] - indexes[0]
            }
            res[indexes[0]] = sum
            for (i in 1 until indexes.size) {
                sum += (indexes[i] - indexes[i-1]) * i //distance with elements on its left increases
                sum -= (indexes[i] - indexes[i-1]) * (indexes.size - i) //distances between elements on its right decrease
                res[indexes[i]] = sum
            }
        }
        return res
    }
}