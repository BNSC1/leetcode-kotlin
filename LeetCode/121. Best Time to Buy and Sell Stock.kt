class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var b = 0 //buy time
        var s = 1 //sell time

        while(s < prices.size) {
            if (prices[b] < prices[s]) { //when the buy price is cheaper than the sell price
                profit = Math.max(profit, prices[s]-prices[b]) //take greater profit if the buy/sell combo yields more
            } else { //when the sell price is cheaper than the buy price
                b = s //switch the buy time to the current sell time because it is lower
            }
            s++ //check the next sell time
        }
        return profit //will be 0 if there is no good buy/sell time
    }
}
