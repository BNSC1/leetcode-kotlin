class Solution {
    fun longestValidParentheses(s: String): Int {
        val st = Stack<Int>().apply { push(-1) }
        var res = 0

        s.forEachIndexed { i, it ->
            if (it == '(') {
                st.push(i)
            } else {
                st.pop()
                if (st.isEmpty()) {
                    st.push(i)
                } else {
                    res = (i - st.peek()).coerceAtLeast(res)
                }
            }
        }
        return res
    }
}