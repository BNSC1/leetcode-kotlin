class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val minHeap = PriorityQueue<Int>()
        val res = IntArray(nums.size)
        
        nums.forEach {
            minHeap.add(it * it)
        }
        res.forEachIndexed { i, it ->
            res[i] = minHeap.poll()
        }
        return res
    }
}