class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()

        nums.forEachIndexed { i, it -> //loop for the first value of 3sum
            if (i > 0 && it == nums[i - 1]) return@forEachIndexed //if "it" is the same as previous number, skip it

            var l = i+1 //with the left pointer init as first value index+1
            var r = nums.size-1 //with the right pointer init as nums last value index
            while (l < r) { //while the left pointer index is lesser than the right one
                val _3sum = it + nums[l] + nums[r]
                if (_3sum > 0) r-- //if the 3sum is too great, move the right pointer index by -1
                else if (_3sum < 0) l++ //if the 3sum is too less, move the left pointer index by 1
                else {
                    res.add(listOf(it, nums[l], nums[r])) //add the 3sum to the result
                    l++ //move the left pointer index by 1 to avoid the same 3sum
                    while (nums[l] == nums[l-1] && l < r) { //move by 1 again if the left pointer still has the same value as previous one
                        l++
                    }
                }
            }
        }

        return res
    }
}
