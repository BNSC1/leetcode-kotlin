class Solution {
    fun longestPalindrome(s: String): Int {
        var res = 0
        val set = HashSet<Char>()

        s.forEach {
            if (it in set) { //if the char is in the set
                set.remove(it)
                res+=2 //remove it and add result by 2
            } else { //if not add it to the set
                set.add(it)
            }
        }

        return if (set.isNotEmpty()) ++res //if the set is not empty, it means there is one or more chars not in pair, add result by 1 as a char in the middle of a palindrome
               else res //otherwise just return the result
    }
}
