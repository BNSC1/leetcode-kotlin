class Tester {
    @Test
    fun main() {
        Solution().apply {
            findBuildings(intArrayOf(1, 2, 3)) `should be equal to` intArrayOf(2)
            findBuildings(intArrayOf(3, 2, 1)) `should be equal to` intArrayOf(0, 1, 2)
            findBuildings(intArrayOf(3, 1, 2)) `should be equal to` intArrayOf(0, 2)
            findBuildings(intArrayOf(1, 3, 2, 4)) `should be equal to` intArrayOf(3)
            findBuildings(intArrayOf(4, 2, 3, 1)) `should be equal to` intArrayOf(0, 2, 3)
            findBuildings(intArrayOf(1)) `should be equal to` intArrayOf(0)
            findBuildings(intArrayOf(1, 1, 1)) `should be equal to` intArrayOf(2)
        }
    }
}

class Solution {
    fun findBuildings(heights: IntArray): IntArray {
        val res = mutableListOf<Int>()
        var currMax = 0
        for (i in heights.size - 1 downTo 0) {
            val h = heights[i]
            if (h > currMax) {
                res.add(i)
                currMax = h
            }
        }
        return res.reversed().toIntArray()
    }
}