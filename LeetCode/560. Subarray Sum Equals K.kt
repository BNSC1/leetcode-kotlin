class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var res = 0
        var curr = 0
        val prefixes = HashMap<Int, Int>().also {
            it[0] = 1 //base case
        } //prefix sum: count

        nums.forEach {
            curr += it
            val diff = curr - k
            res += prefixes.getOrDefault(diff, 0) //if there are ways to reach the diff value, add to the result
            prefixes[curr] = prefixes.getOrDefault(curr, 0) + 1 //add 1 way to lead to current value
        }
        return res
    }
}