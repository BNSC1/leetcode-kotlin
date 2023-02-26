class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val res = mutableListOf<String>()
        val str = ArrayDeque<Char>()

        fun generate(open: Int, close: Int) {
            if (open == 0 && close == 0) { //when this branch reaches to the end (no more parentheses remaining)
                res.add(str.reversed().joinToString(separator = ""))  //add to the result
                return //close this branch
            }
            if (open > 0) { 
                str.push('(')
                generate(open-1, close) //start a branch with an open parenthes added
                str.pop() //restore stack
            }
            if (close > open) { //if there are more closed parentheses remaining
                str.push(')')
                generate(open, close-1) //start a branch with a closed parenthes added
                str.pop() //restore stack
            }
        }

        generate(n, n)
        return res
    }
}