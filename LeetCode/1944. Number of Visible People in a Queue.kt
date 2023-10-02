class Solution {
    fun canSeePersonsCount(heights: IntArray): IntArray {
        val size = heights.size
        val res = IntArray(size)
        val st = LinkedList<Int>()

        for (i in size - 1 downTo 0) {
            val curPerson = heights[i]

            while (st.isNotEmpty()) {
                val nextPerson = st.peek()

                res[i]++
                if (nextPerson > curPerson) break
                else st.pop()
            }
            st.push(curPerson)
        }
        return res
    }
}