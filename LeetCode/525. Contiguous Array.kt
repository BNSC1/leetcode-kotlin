class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val map = HashMap<Int, Int>() // sum : latest index with this sum
        var sum = 0
        var res = 0

        nums.forEachIndexed { i, it ->
            sum += if (it == 0) -1 else 1 //turn 0 to -1

            if (sum == 0) { //if sums to 0, it means from start to current position, there are equal nums of 0's and 1's
                res = Math.max(res, i+1)
            } else if (sum in map) { //if there is an index with the same sum in the map, subtract current index with that index
                res = Math.max(res, i-map[sum]!!)
            } else {
                map[sum] = i //assign this sum with latest index
            }
        }
        return res
    }
}