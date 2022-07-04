class Solution {
    fun minRemoveToMakeValid(s: String): String {
        val st = Stack<Int>() // to store indexes of '('
        val sb = StringBuilder(s) //use StringBuilder instead because removeRange() does not change the length of a string

        var i = 0
        while (i < sb.length) {
            if (sb[i] == '(') { //add '(' to the stack
                st.add(i)
            } else if (sb[i] == ')') {
                if (st.empty()) { //delete this ')' if no '(' are in the stack
                    sb.delete(i,i+1)
                    i-- //deleted a char, we move the index back, so we don't skip an element
                } else { //pop a stack of '(' if it is not empty
                    st.pop()
                }
            }
            i++
        }
        while (st.isNotEmpty()) { //delete leftover '('
            val index = st.pop()
            sb.delete(index, index+1)
        }
        return sb.toString()
    }
}
