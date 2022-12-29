class Solution {
    fun dailyTemperatures(ts: IntArray): IntArray {
        val res = IntArray(ts.size) {0} //array with size of temp array, initated with 0
        val stack = LinkedList<Int>() //stack of index, ArrayDeque is more efficient than LinkedList

        ts.forEachIndexed { day, temp -> //loop through each day
            while (stack.isNotEmpty() && temp > ts[stack.peek()]) {
                val evalDay = stack.pop() //pop the day when the current day is warmer than it
                res[evalDay] = day - evalDay // day difference to result
            }
            stack.push(day) //push the day to stack for evaluation to get warmer day
        }
        return res
    }
}
