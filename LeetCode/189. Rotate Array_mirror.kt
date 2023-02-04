class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        var k = k % nums.size //case if k is more than the size of nums

        fun mirror(l: Int, r: Int) {
            var l = l
            var r = r
            while (l < r) {
                val tmp = nums[l]
                nums[l] = nums[r]
                nums[r] = tmp
                l++
                r--
            }
        }
        // [1,2,3,4,5,6,7], k = 3

        //mirror the whole array
        mirror(0, nums.size - 1) // [7,6,5,4,3,2,1]

        //mirror subarray before k
        mirror(0, k - 1) // [5,6,7,4,3,2,1]

        //mirror subarray after k
        mirror(k, nums.size - 1) // [5,6,7,1,2,3,4]
    }
}