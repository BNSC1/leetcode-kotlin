class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val k = nums.size - k //kth "smallest" index

        fun quickSelect(l: Int, r: Int): Int {
            val pivot = nums[r] //r index value as pivot
            var p = l //p index start at l
            for (i in l until r) { //partition elements smaller than p to its left
                if (nums[i] <= pivot) {
                    var tmp = nums[p]
                    nums[p] = nums[i]
                    nums[i] = tmp
                    p++
                }
            }
            //elements before p are less or equal to nums[p]
            //elements before p are greater than nums[p]

            //swap p value with pivot value
            var tmp = nums[p]
            nums[p] = nums[r]
            nums[r] = tmp

            return if (p > k) { //look left partition if p is the smaller index
                quickSelect(l, p-1)
            } else if (p < k) { //look right partition if p is the greater index
                quickSelect(p+1, r)
            } else nums[p] //return if it is exactly the kth smallest index
        }

        return quickSelect(0, nums.size - 1)
    }
}