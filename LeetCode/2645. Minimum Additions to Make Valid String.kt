class Solution {
    fun addMinimum(word: String): Int {
        var res = 0
        
        var last = word[0]
        res += word[0] - 'a'
        for (i in 1 until word.length) {
            val curr = word[i]
            if (curr > last) {
                res += curr - last - 1
            } else {
                res += curr - last + 2
            }
            last = curr
        }
        res += 'c' - last
        return res
    }
}