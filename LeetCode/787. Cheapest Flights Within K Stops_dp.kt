class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val routeCosts = Array(k + 2) {
                IntArray(n) {Int.MAX_VALUE} //cost to destinations in number of flights
            }

        for (numFlight in 0..k) {
            routeCosts[numFlight][src] = 0
        } //iterated base case because there can be results with less than k stops
        for (numFlight in 1..k + 1) {
            for (flight in flights) {
                val (srcAirport, destAirport, cost) = flight

                val prevCost = routeCosts[numFlight - 1][srcAirport]
                if (prevCost != Int.MAX_VALUE) { //if price data from the previous stop exists
                    val prevCalc = routeCosts[numFlight][destAirport]
                    routeCosts[numFlight][destAirport] = prevCalc.coerceAtMost(prevCost + cost)
                }
            }
        }
        val destCost = routeCosts[k + 1][dst]
        return if (destCost == Int.MAX_VALUE) -1
               else destCost
    }
}