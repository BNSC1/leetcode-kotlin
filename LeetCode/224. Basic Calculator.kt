class Solution {
    fun calculate(s: String): Int {
        var currSum = 0
        var sign = 1
        var currVal = 0
        val stack = LinkedList<Pair<Int, Int>>() //sign: value

        s.forEach { c ->
            when {
                c.isDigit() -> {
                    currVal = currVal * 10 + c.toString().toInt()
                }
                c in "+-" -> {
                    currSum += (currVal*sign)
                    currVal = 0
                    sign = if (c == '-') -1 else 1
                }
                c == '(' -> { //push and clear current result
                    stack.push(Pair(sign, currSum))
                    currSum = 0
                    sign = 1
                }
                c == ')' -> { //pull and add current value to current result
                    currSum += (currVal * sign)
                    val op = stack.poll()
                    currSum *= op.first
                    currSum += op.second
                    currVal = 0
                }
            }
        }
        return currSum + (currVal*sign)
    }
}