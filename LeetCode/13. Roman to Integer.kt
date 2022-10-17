class Solution {
    fun romanToInt(s: String): Int {
        val map = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        ) // map for roman number
        var res = 0
        val len = s.length

        s.forEachIndexed { i, it ->
            res += map[it]!!.let { num -> //"map[it]!!" is "num" in lambda
                if (i < len - 1 && num < map[s[i+1]]!!) {
                    //when the current char is not the last one, and the next one is greater than the current one, subtract it
                    -num
                } else num //otherwise add it
            }
        }
        return res
    } // TC: O(s.length), SC: O(1)
}
