class Solution {
    val res = mutableListOf<List<Int>>()
    fun subsets(nums: IntArray): List<List<Int>> {
        backtrack(nums)
        return res
    }

    fun backtrack(nums: IntArray, tmp: MutableList<Int> = mutableListOf(), start: Int = 0) {
        res.add(ArrayList(tmp)) //add a new copy of temp list to result

        for (i in start until nums.size) {
            tmp.add(nums[i]) //add number for current decision
            backtrack(nums, tmp, i + 1) //recursion for subset for the next number
            tmp.removeAt(tmp.lastIndex) //restore to previous state for another decision after backtracking, as in java, list is passed by reference
        }
    }
}
