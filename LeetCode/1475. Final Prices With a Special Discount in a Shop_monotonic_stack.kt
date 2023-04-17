class Solution {
    fun finalPrices(prices: IntArray): IntArray {
        val res = prices.clone()
        val st = LinkedList<Int>()
        
        for (i in prices.size-1 downTo 0) {
            while (st.isNotEmpty() && prices[i] < st.peek()) {
                st.pop()
            }
            if (st.isNotEmpty()) {
                res[i] = prices[i] - st.peek()
            }
            st.push(prices[i]) //all nums will be pushed
        }
        return res
    }
}