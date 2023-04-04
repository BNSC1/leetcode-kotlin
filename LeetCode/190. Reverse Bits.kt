class Solution {
    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {
        var res = 0
        for (i in 0 until 32) {
            val bit = (n shr i) and 1 //take only 1 right bit
            res = res or (bit shl 31 - i) //shift the bit to the left
        }
        return res
    }
}