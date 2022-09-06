class MyQueue() {
    val st1 = Stack<Int>()
    val st2 = Stack<Int>()
    var front: Int? = null

    fun push(x: Int) = st1.run {
        if (isEmpty()) front = x //assign to the front element if it is the first element for stack 1
        add(x) //then add it to stack 1
    }

    fun pop() = st2.run {
        if (isEmpty()) { //if stack 2 is empty
            while (!st1.isEmpty()) add(st1.pop()) //dump all elements from stack 1 to stack 2
        }
        pop() //then pop an element from stack 2
    }

    fun peek() = st2.run {
        if(!isEmpty()) peek() //if stack 2 is not empty (ran pop() before) then peek it
        else front //else return the front element
    }

    fun empty() = st1.empty() && st2.empty()

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
