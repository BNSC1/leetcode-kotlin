class Solution {
    fun isValid(s: String): Boolean {
        val st = Stack<Char>()

        s.forEach {
            when (it) {
                '{' -> st.add(it)
                '[' -> st.add(it)
                '(' -> st.add(it) //add open parenthese to stack

                ')' -> if (st.isEmpty() || st.pop() != '(') return false
                ']' -> if (st.isEmpty() || st.pop() != '[') return false
                '}' -> if (st.isEmpty() || st.pop() != '{') return false //pop stack and check if it is matching parenthese, or return false if the stack is already empty
            }
        }
        return st.isEmpty() //return true if the stack has no leftover parentheses
    }
}
