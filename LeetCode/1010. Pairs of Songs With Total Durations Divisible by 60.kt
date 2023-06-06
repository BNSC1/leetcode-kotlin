class Solution {
    fun numPairsDivisibleBy60(time: IntArray): Int {
        var res = 0
        val map = HashMap<Int, Int>().withDefault {0}
        time.forEach { t ->
            val rem = t % 60
            val diff = (60 - rem) % 60 //edge case 0 diff
            res += map.getValue(diff)
            map[rem] = map.getValue(rem) + 1
        }
        return res
    }
}