 class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false //if they have different length, they can't be anagram
        val mapS = hashMapOf<Char,Int>()
        val mapT = hashMapOf<Char,Int>() //hash maps to record appearance count of each chars

        s.forEach {
            mapS[it] = mapS.getOrDefault(it, 0) + 1
            mapT[it] = mapT.getOrDefault(it, 0) + 1
        }

        return mapS.equals(mapT) //compare the hash maps to see if they have the same keys and values
    }
}
