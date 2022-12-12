class Solution {
    fun letterCombinations(d: String): List<String> {
        val res = mutableListOf<String>()
        if (d.isEmpty()) return res //return empty list on empty digits
        val map = mapOf('2' to "abc",
                        '3' to "def",
                        '4' to "ghi",
                        '5' to "jkl",
                        '6' to "mno",
                        '7' to "pqrs",
                        '8' to "tuv",
                        '9' to "wxyz") //map digit to letters

        fun backtrack(i: Int, curr: String) {
            if (curr.length == d.length) {
                res.add(curr)
                return //if the current string is already the same length as digits, add to the result and skip
            }

            map[d[i]]!!.forEach { //loop letters in the digit for the next letter
                backtrack(i + 1, curr + it)
            }
        }

        backtrack(0, "")
        return res
    }
}
