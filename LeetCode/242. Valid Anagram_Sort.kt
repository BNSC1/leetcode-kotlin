class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        return s.toCharArray().sorted() == t.toCharArray().sorted() //convert to char array and sort
    }
}
