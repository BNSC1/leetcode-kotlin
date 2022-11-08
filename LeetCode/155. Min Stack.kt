class MinStack() {
    private val st = LinkedList<Int>()
    private val minSt = LinkedList<Int>() //aside from regular stack, setup a stack to store min values

    fun push(`val`: Int)  = st.push(`val`).also {
        val min = minSt.peek()?.let {
            Math.min(`val`, it)
        } ?: `val` //min = val if min stack is empty, otherwise take the less of peeked min value or val
        minSt.push(min) //when pushing a value to regular stack, also push a min value to min stack
    }

    fun pop() {
        st.pop()
        minSt.pop() //pop min stack along with regular stack
    }

    fun top() = st.peek()

    fun getMin() = minSt.peek() //peek the min stack for current min value

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
