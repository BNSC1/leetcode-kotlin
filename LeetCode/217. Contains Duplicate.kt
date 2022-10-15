class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()

        nums.forEach { // loop thru the array
            if (it !in set) set.add(it) // if the num is not in the set, add it
            else return true // otherwise the num is in the set already, return true
        }
        return false // if no duplicate is found, return false
    }
} //TC: O(n) SC: O(n)
