class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size-1 //define left and right index

        while (l <= r) {
            val m : Int = (r+l) / 2 //get mid index to divide the array by half

            if (nums[m] > target) { //if the mid index element is bigger than the target
                r = m-1 //move the right index before the mid index to take the left array into the next loop
            } else if (nums[m] < target) { //if the mid index element is smaller than the target
                l = m+1 //move the left index after the mid index to take the right array into the next loop
            } else return m //return the index if it has the value same as the target
        }
        return -1 //return -1 if nothing matches.
    }
}
