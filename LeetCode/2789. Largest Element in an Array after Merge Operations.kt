class Solution {
    fun maxArrayValue(nums: IntArray): Long {
        val list = mutableListOf<Long>().apply {
            nums.forEach {
                add(it.toLong())
            }
        }
        var lastSize = 0
        while (lastSize != list.size) {
            lastSize = list.size

            var i = list.size - 1
            while (i > 0) {
                if (list[i-1] <= list[i]) {
                    list[i-1] += list[i]
                    list.removeAt(i)
                }
                i--
            }
        }
        return list.max()!!
    }
}