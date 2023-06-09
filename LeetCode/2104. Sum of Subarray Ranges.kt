class Solution {
    fun subArrayRanges(nums: IntArray): Long {
        fun sumOf(target: Target): Long {
            var res = 0L
            val st = LinkedList<Pair<Int,Int>>().apply { push(-1 to target.xVal) }
            fun popAt(i: Int) = st.pop().let { (popI, popN) ->
                res += popN.toLong() * (i - popI) * (popI - st.peek().first)
            }
            nums.forEachIndexed { i, n ->
                while(target.extremeOf(st.peek().second, n) == n) {
                    popAt(i)
                }
                st.push(i to n)
            }
            while (st.size > 1) {
                popAt(nums.size)
            }
            return res
        }
        return sumOf(Target.LARGEST) - sumOf(Target.SMALLEST)
    }
    enum class Target(val xVal: Int) {
        LARGEST(Int.MAX_VALUE) {
            override fun extremeOf(a: Int, b: Int) = maxOf(a, b)
        },
        SMALLEST(Int.MIN_VALUE) {
            override fun extremeOf(a: Int, b: Int) = minOf(a, b)
        };
        abstract fun extremeOf(a: Int, b: Int): Int
    }
}