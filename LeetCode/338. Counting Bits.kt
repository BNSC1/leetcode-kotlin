class Solution {
    fun countBits(n: Int): IntArray {
        val arr = IntArray(n+1)
        var offset = 1 //starting only 1 bit is repeated

        for (i in 1..n) {
            if (offset * 2 == i) {
                offset = i //offset is carried 1 bit if current calculation has one more bit than it has
            }
            arr[i] = 1 + arr[i - offset] //1 + previous results until carry occurs
        }
        return arr
    } //TC: O(n), SC: O(n)
}
