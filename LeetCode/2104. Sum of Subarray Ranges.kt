class Solution {
    fun subArrayRanges(nums: IntArray) = sumOf(nums, Target.LARGEST) - sumOf(nums, Target.SMALLEST)

    private fun sumOf(nums: IntArray, target: Target): Long {
        var res = 0L
        val stack = LinkedList<Pair<Int, Int>>().apply { push(-1 to target.xVal) } //num, index
        fun popAt(index: Int) = stack.pop().let { (popIndex, popNum) ->
            res += popNum.toLong() * (popIndex - stack.peek().first) * (index - popIndex)
        }
        nums.forEachIndexed { index, num ->
            while (target.extremeOf(num, stack.peek().second) == num) {
                popAt(index)
            }
            stack.push(index to num)
        }
        while (stack.size > 1) {
            popAt(nums.size)
        }
        return res
    }

    private enum class Target(val xVal: Int) {
        LARGEST(Int.MAX_VALUE) {
            override fun extremeOf(a: Int, b: Int) = maxOf(a, b)
        },
        SMALLEST(Int.MIN_VALUE) {
            override fun extremeOf(a: Int, b: Int) = minOf(a, b)
        };

        abstract fun extremeOf(a: Int, b: Int): Int
    }
}