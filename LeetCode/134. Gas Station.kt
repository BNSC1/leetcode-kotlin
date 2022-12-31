class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if (gas.sum() < cost.sum()) { //a full cycle is impossible if total gas is less than total cost
            return -1
        }
        var total = 0
        var start = 0

        for (i in 0 until gas.size) {
            total += (gas[i] - cost[i]) //sums differences between gas and cost
            if (total < 0) { //if total is negative
                total = 0 //reset total
                start = i + 1 //it means this position is not a good start, moving to the next position
            }
        }
        return start
    }
}
