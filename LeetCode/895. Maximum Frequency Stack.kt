class FreqStack() {
    val freqs = HashMap<Int, Int>().withDefault {0} //value: freq
    val stacks = HashMap<Int, LinkedList<Int>>().withDefault{LinkedList()} //freq : values with this freq, store the add order of current freq
    var max = 0
    fun push(`val`: Int) {
        val currFreq = freqs.getValue(`val`) + 1
        freqs[`val`] = currFreq
        max = currFreq.coerceAtLeast(max)
        stacks[currFreq] = stacks.getValue(currFreq).apply {push(`val`)}
    }

    fun pop(): Int {
        val res = stacks[max]!!.pollFirst()
        freqs[res] = freqs[res]!! - 1
        if (stacks[max]!!.isEmpty()) {
            max--
        }
        return res
    }

}

/**
 * Your FreqStack object will be instantiated and called as such:
 * var obj = FreqStack()
 * obj.push(`val`)
 * var param_2 = obj.pop()
 */