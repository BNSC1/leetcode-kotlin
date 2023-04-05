class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        var prices = IntArray(n) {Int.MAX_VALUE}
        prices[src] = 0

        repeat(k + 1) {
            val tempPrices = prices.clone() //temp array so it contains results only with same count of stops visited

            flights.forEach {
                val (s, d, p) = it //source, destination, price of the edge

                if (prices[s] == Int.MAX_VALUE) return@forEach //skip unvisited src stop
                if (prices[s] + p < tempPrices[d]) {
                    tempPrices[d] = prices[s] + p
                }
            }
            prices = tempPrices
        }
        return if (prices[dst] == Int.MAX_VALUE) -1 else prices[dst]
    }
}