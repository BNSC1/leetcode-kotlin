class Solution {
    fun countSubstrings(str: String): Int {
        val len = str.length
        val dp = Array(1001) {BooleanArray(1001)}
        fun dp(s: Int, e: Int): Boolean {
            dp[s][e] = if (s == e) true
            else if (e - s == 1) {
                if (str[s] == str[e]) true
                else false
            } else if (str[s] == str[e] && dp[s+1][e-1]) true
            else false
            return dp[s][e]
        }

        var res = 0
        var start = 0
        repeat(len) { endFrom ->
            var s = 0
            var e = endFrom
            while (e < len) {
                if (dp(s, e)) res++
                s++
                e++
            }
        }
        return res
    }
}