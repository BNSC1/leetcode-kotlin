class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var res = 0
        val set = HashSet<Int>() //set for consecutive number
        nums.forEach {
            set.add(it)
        } //add all nums to a set
        
        nums.forEach {
            if (it-1 !in set) { //if it is the head of a consecutive sequence
                var cnt = 0

                while (it + cnt in set) { //start counting length of the sequence by checking if the next number is in the set
                    cnt++
                }
                res = Math.max(res, cnt) //replace the result if the sequence is longer
            }
        }
        return res
    }
}