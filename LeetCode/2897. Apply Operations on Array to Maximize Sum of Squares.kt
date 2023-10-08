class Solution {
    fun maxSum(nums: List<Int>, k: Int): Int {
        val bits = IntArray(32)
        val offset = 1000000007L
        nums.forEach { num ->
            repeat(32) { i ->
                if (num and (1 shl i) != 0) bits[i]++
            }
        } //counting for each bit

        var res = 0L
        repeat(k) {
            var cur = 0L
            repeat(32) { i ->
                if (bits[i] > 0) {
                    bits[i]--
                    cur = cur or (1 shl i).toLong()
                }
            } //pick all available bits
            res = (res + cur * cur % offset) % offset
        }
        return res.toInt()
    }
}