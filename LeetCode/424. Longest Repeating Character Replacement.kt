class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val cnt = HashMap<Char, Int>() //Character: Char count in the window
        var res = 0
        var l = 0
        var mostFreq = 0 //count of the most frequently appeared char

        for (r in 0 until s.length) { //l and r form a window
            cnt[s[r]] = cnt.getOrDefault(s[r], 0) + 1 //addition to the iterated char by r
            mostFreq = Math.max(mostFreq, cnt[s[r]]!!) //update mostFreq if the char becomes the most frequent

            if ((r - l + 1) - mostFreq > k) { //if the window has replaced more than k chars
                cnt[s[l]] = cnt[s[l]]!! - 1 //subtract the count of the left char
                l++ //slide the left pointer
            }

            res = Math.max(res, r - l + 1) //update result if the window is longer than before
        }

        return res
    }
}