class Solution {
    val res = mutableListOf<List<Int>>()
    fun permute(nums: IntArray): List<List<Int>> {
        backtrack(nums)
        return res.toList() //immutable list required
    }

    fun backtrack(nums: IntArray, tmp: MutableList<Int> = mutableListOf()) {
        if (tmp.size == nums.size) res.add(ArrayList(tmp)) //if all elements are added to temp list, add a new copy of it to result
        else {
            for (i in 0 until nums.size) {
                if(tmp.contains(nums[i])) continue //ignore duplicate
                tmp.add(nums[i]) //add number for current decision
                backtrack(nums, tmp) //recursion for permutation for the next number
                tmp.removeAt(tmp.size - 1) //restore to previous state for another decision after backtracking
            }
        }
    }
}
