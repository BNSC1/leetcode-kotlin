class Solution {
    fun longestValidParentheses(s: String): Int {
        var l = 0
        var r = 0
        var res = 0

        s.forEach {
            if (it == '(') l++
            else r++
            if (l == r) res = (r * 2).coerceAtLeast(res)
            if (r > l) { //ignore redundant closing
                l = 0
                r = 0
            }
        }
        l = 0
        r = 0

        s.reversed().forEach {
            if (it == '(') l++
            else r++
            if (l == r) res = (r * 2).coerceAtLeast(res)
            if (l > r) {
                l = 0
                r = 0
            }
        }
        return res
    }
}