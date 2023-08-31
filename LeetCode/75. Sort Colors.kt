class Solution {
    val RED = 0
    val WHITE = 1
    val BLUE = 2

    fun sortColors(nums: IntArray) {
        var red = 0
        var white = 0
        var blue = nums.size - 1
        
        fun swap(a: Int, b: Int) {
            val tmp = nums[a]
            nums[a] = nums[b]
            nums[b] = tmp
        }

        while(white <= blue) {
            when (nums[white]) {
                RED -> {
                    swap(white, red)
                    red++
                    white++ //the pointed element is in correct position, increment both what they are pointing to by 1
                }
                WHITE -> white++
                BLUE -> {
                    swap(white, blue)
                    blue-- //subtract by 1 as the previous element does not need moving anymore
                }
            }
        }
    }
}
