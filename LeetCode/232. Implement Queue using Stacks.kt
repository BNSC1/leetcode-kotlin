class MyQueue() {
    val st = Stack<Int>()
    
    fun push(x: Int) = st.add(x)

    fun pop(): Int {
        val s = Stack<Int>() //temp stack
        for (i in st.indices) {
            s.add(st.pop())
        } //pop all elements to the temp stack
        val res = s.pop() //pop the top element of the temp stack, which was the bottom one of the main stack
        for (i in s.indices) {
            st.add(s.pop())
        } //pop the remaining back to the main stack
        return res
    }

    fun peek() : Int {
        val s = Stack<Int>()
        for (i in 0..st.size-2) {
            s.add(st.pop())
        } //pop elements until the bottom element
        val res = st.peek() //peek at the bottom element
        for (i in s.indices) {
            st.add(s.pop())
        } //pop back to the main stack
        return res
    }

    fun empty() = st.empty()

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */