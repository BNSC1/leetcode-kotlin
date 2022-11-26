class Solution {
    fun canPartition(nums: IntArray): Boolean {
        if (nums.sum() % 2 == 1) return false //if the sum is odd, subsets are never equal
        var subsums = HashSet<Int>()
        subsums.add(0) //base case
        val target = nums.sum() / 2

        nums.forEach { n ->
            val set = HashSet<Int>() //new set for each iteration then assign to subsums to avoid ConcurrentModificationException
            subsums.forEach { s ->
                val subsum = n + s
                if (subsum == target) return true //return if subsum is equal to target
                if (subsum < target) set.add(subsum) //add to set if subsum is lesser than the target
                set.add(s) //add the subsum to new set
            }
            subsums = set
        }
        return false //if no subsum equals, return false
    }
}
