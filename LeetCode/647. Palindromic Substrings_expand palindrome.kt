class Solution {
    fun countSubstrings(str: String): Int {
        val len = str.length
        var res = 0
        fun count(s: Int, e: Int) {
            var s = s
            var e = e
            while (s >= 0 && e < len && str[s--] == str[e++]) {
                res++
            }
        }
        repeat(len) { i ->
            count(i, i)
            count(i, i+1)
        }
        return res
    }
}