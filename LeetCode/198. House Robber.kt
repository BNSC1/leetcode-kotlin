class Solution {
    fun rob(nums: IntArray): Int {
        var rob1 = 0 //previous rob result
        var rob2 = 0 //result with attempt to rob most recently iterated house

        nums.forEach { n -> //iterate through each house
            //if we sum previous rob result yet it is still lesser than rob2, take rob2 as result,
            //then sum n+1 house as result, don't always need to take the next 2 house as result e.g.
            //[  9, 11,  1,  9]
            //[ r1, r2,  n,n+1]
            val tmp = Math.max(rob1 + n, rob2)
            rob1 = rob2
            rob2 = tmp
        }
        return rob2
    }
}
