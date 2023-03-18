class Solution {
    fun largestNumber(nums: IntArray): String {
        val sorted = nums.sortedWith(Comparator<Int> { a, b -> "$b$a".compareTo("$a$b") }) //sort by comparing each string in 2 combinations

        return if (sorted[0] == 0) "0" //return 0 if the biggest number, which should be in the first index, is 0
               else sorted.joinToString("") //join the sorted array to string
    }
}