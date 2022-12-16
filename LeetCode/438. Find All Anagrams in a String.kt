class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val res = mutableListOf<Int>()
        if (p.length > s.length) return res //return empty list if p is longer than s

        val sCnt = HashMap<Char, Int>() //s char: char count
        val pCnt = HashMap<Char, Int>() //p char: char count

        for (i in 0 until p.length) {
            pCnt[p[i]] = pCnt.getOrDefault(p[i], 0) + 1
            sCnt[s[i]] = sCnt.getOrDefault(s[i], 0) + 1
        } //include first p length of chars
        if (sCnt == pCnt) res.add(0) //if both maps ended up the same, add 0 to the result

        var l = 0
        for (r in p.length until s.length) {
            sCnt[s[r]] = sCnt.getOrDefault(s[r], 0) + 1
            sCnt[s[l]] = sCnt.getOrDefault(s[l], 0) - 1 //slide window

            if (sCnt[s[l]] == 0) {
                sCnt.remove(s[l])
            } //if the key value reaches 0, remove from the map
            l++ //slide to the right
            if (sCnt == pCnt) res.add(l) //add the left pointer if the maps being the same in the progress
        }
        return res
    }
}
