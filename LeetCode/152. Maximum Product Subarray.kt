class Solution {
    fun maxProduct(nums: IntArray): Int {
        var res = nums.max()!! //initialize with max value in the array
        var min = 1 //taking minimum value as well because if a negative value is multiplied by another negative, it becomes positive
        var max = 1 //initial value is 1 instead because if we multiply by 0, the value becomes 0

        nums.forEach {
            val oldMin = min //assign old value because min and max should be updated at the same time
            min = minOf(min*it, max*it, it)
            max = maxOf(oldMin*it, max*it, it)
            res = maxOf(min, max, res)
        }
        return res
    }
}
