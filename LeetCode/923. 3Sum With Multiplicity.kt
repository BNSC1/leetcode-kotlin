class Solution {
    fun threeSumMulti(arr: IntArray, target: Int): Int {
        var res = 0L
        val map = HashMap<Int, Long>().withDefault{0L}
        arr.forEach {
            map[it] = map.getValue(it) + 1
        }

        for (i in 0..100) {
            for (j in i..100) {
                val k = target - i - j
                if (k !in 0..100) continue
                if (i == j && j == k) {
                    res += map.getValue(i) * (map.getValue(i) - 1) * (map.getValue(i) - 2) / 6
                } else if (i == j && j != k) {
                    res += map.getValue(i) * (map.getValue(i) - 1) / 2 * map.getValue(k)
                } else if (j < k) {
                    res += map.getValue(i) * map.getValue(j) * map.getValue(k)
                }
            }
        }
        return (res % (1e9 + 7)).toInt()
    }
}