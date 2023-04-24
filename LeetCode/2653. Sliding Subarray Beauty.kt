class Solution {
    fun getSubarrayBeauty(nums: IntArray, size: Int, thSmallest: Int): IntArray {
        val res = IntArray(nums.size - size + 1) {0}
        val cnts = IntArray(51)
        var start = 0
        for (end in nums.indices) {
            if (nums[end] < 0) cnts[Math.abs(nums[end])]++ //add the end number
            if (end - start + 1 >= size) { //enough window length
                var nth = 0
                for (l in 50 downTo 1) { //iterate every numbers
                    nth += cnts[l]
                    if (nth >= thSmallest) { //nth smallest number found
                        res[start] = -l
                        break
                    }
                }
                if (nums[start] < 0) cnts[Math.abs(nums[start])]-- //pop the start number
                start++
            }
        }
        return res
    }
}