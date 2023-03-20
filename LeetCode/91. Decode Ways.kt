class Solution {
    fun numDecodings(s: String): Int {
        val dp = hashMapOf(s.length to 1) //index : result count, with base case s.length : 1

        for(i in s.length - 1 downTo 0) { //bottom-up
            dp[i] = if (s[i] == '0') 0 //the rest of result will be 0 too, if there is a 0 in the string
            else dp[i + 1]!! //assign the previous result

            //check possible 2-digit case
            if (i + 1 < s.length && //if i + 1 is not out of bounds
                (s[i] == '1' || 
                s[i] == '2' && s[i+1] in "0123456") //and the number is between 10 and 26
            ) {
                dp[i] = dp[i]!! + dp[i + 2]!! //combine current result with i + 2 for the 2-digit case
            }
        }
        return dp[0]!!
    }

}