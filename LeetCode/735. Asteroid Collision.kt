class Solution {
    fun asteroidCollision(asts: IntArray): IntArray {
        val st = Stack<Int>()

        var i = 0
        while (i < asts.size) {
            val curr = asts[i]
            when {
                st.isEmpty() -> {
                    st.push(curr)
                    i++
                }
                st.peek() > 0 && curr < 0 -> { //collide occurs
                    when {
                        Math.abs(st.peek()) > Math.abs(curr) -> {
                            //current astroid will be destroyed if the stack one is greater
                            i++
                        }
                        Math.abs(st.peek()) < Math.abs(curr) -> {
                            //stack astroid will be destroyed if the current one is greater
                            st.pop()
                        }
                        else -> {
                            //both will be destroyed
                            st.pop()
                            i++
                        }
                    }
                }
                else -> {
                    st.push(curr)
                    i++
                }
            }
        }
        return st.toIntArray()
    }
}