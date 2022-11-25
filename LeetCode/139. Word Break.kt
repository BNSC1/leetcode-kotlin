class Solution {
    fun wordBreak(s: String, d: List<String>): Boolean {
        val dp = Array<Boolean>(s.length+1) {false} //init boolean array with default value being false
        dp[s.length] = true //base case

        for (i in s.length-1 downTo 0) { //backtrack combinations of length
            for(w in d) { //loop each word in the dictionary
                if (i + w.length <= s.length && //if the word fits into the string from current iteration index to the end
                    s.slice(i until i+w.length) == w) //and if the word from current iteration index to the end matches
                    dp[i] = dp[i + w.length] //set the result to be the case without the word
                if (dp[i]) break //if the dp case is true, continue on the next combination
            }
        }
        return dp[0]
    }
}
