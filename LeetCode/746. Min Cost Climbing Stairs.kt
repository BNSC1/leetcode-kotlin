class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var c1 = cost[0]
        var c2 = cost[1]
        for (i in 2 until cost.size) {
          val cost = cost[i]
          c1 = min(c1, c2) + cost
          val tmp = c1
          c1 = c2
          c2 = tmp
        }
        return min(c1, c2)
    }
}