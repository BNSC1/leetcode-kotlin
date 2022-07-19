class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int,Int>() //num:index

        nums.forEachIndexed{ i, n ->
            val diff = target - n
            if (diff in map) return intArrayOf(i, map[diff]!!) //find in map to see if there is a key same as the diff
            map[n] = i  //if not, add this by num:index to the map
        }
        return intArrayOf()
    }
}
