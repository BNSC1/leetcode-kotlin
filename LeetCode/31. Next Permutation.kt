class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        val pivot = indexOfLastPeak(nums) //get index before the peak
        if (pivot != -1) {
            val nextPrefix = lastIndexOfGreater(nums, nums[pivot]) //find the next greater index than threshold from end to start
            swap(nums, pivot, nextPrefix) //swap position of the pivot and the next greater index
        }
        sort(nums, pivot + 1) //sort from peak to the end
    }

    fun indexOfLastPeak(nums: IntArray): Int {
        for (i in nums.size-1 downTo 1) {
            if (nums[i - 1] < nums[i]) {
                return i - 1
            }
        }
        return -1 //return -1 if none found
    }

    fun lastIndexOfGreater(nums: IntArray, threshold: Int): Int {
        for (i in nums.size-1 downTo 0) {
            if (threshold < nums[i]) {
                return i
            }
        }
        return -1
    }

    fun sort(nums: IntArray, start: Int) {
        var start = start
        var end = nums.size - 1
        while (start < end) {
            swap(nums, start++, end--)
        }
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}
