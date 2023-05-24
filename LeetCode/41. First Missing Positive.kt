class Solution {
    fun firstMissingPositive(ns: IntArray): Int {
        repeat(ns.size) { i -> //neutralize negatives
            ns[i] = ns[i].coerceAtLeast(0)
        }
        repeat(ns.size) { i ->
            val v = Math.abs(ns[i])
            if (v in 1..ns.size) {
                if (ns[v - 1] > 0) ns[v - 1] *= -1 //mark that index visited
                else if (ns[v - 1] == 0) ns[v - 1] = Int.MIN_VALUE //ignore negatives
            }
        }
        for (i in 1..ns.size) { //check missing positives with value those indexes point to
            if (ns[i - 1] >= 0) return i
        }
        return ns.size + 1
    }
}