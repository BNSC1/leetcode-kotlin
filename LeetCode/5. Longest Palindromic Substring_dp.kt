class Solution {
    fun longestPalindrome(str: String): String {
        val len = str.length
        val dp = Array<BooleanArray>(1001) {BooleanArray(1001)}
        fun dp(s: Int, e: Int): Boolean {
            dp[s][e] = if (s == e) true
            else if (e - s == 1) {
                if (str[s] == str[e]) true
                else false
            } else if (str[s] == str[e] && dp[s+1][e-1] == true) true
            else false
            return dp[s][e]
        }

        var maxLen = 0
        var start = 0
        repeat(len) { endFrom ->
            var s = 0
            var e = endFrom
            while (e < len) {
                if (dp(s, e) && e - s + 1 > maxLen) {
                    start = s
                    maxLen = e - s + 1
                }
                s++
                e++
            }
        }
        return str.substring(start until start+maxLen)
    }
}