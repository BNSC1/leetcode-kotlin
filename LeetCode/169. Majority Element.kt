class Solution {
    fun majorityElement(nums: IntArray): Int {
        var majorNum: Int? = null
        var cnt = 0

        nums.forEach {
            if (cnt == 0) { //when the count is 0
                majorNum = it //elect a new major number
            }
            cnt += if (majorNum == it) 1 else -1 //if the number is the same as major number, add count by 1, otherwise subtract by 1
        }
        return majorNum!!
        //this algorithm assumes the major number always has count greater than half of the array's length
    }
}
