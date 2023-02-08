class Solution {
    fun decodeString(s: String): String {
        val stack = ArrayDeque<Char>()

        s.forEach { c ->
                if (c != ']') {
                    stack.push(c)
                } else { //when bracket closed
                    var sb = StringBuilder()
                    
                    while (stack.peek() != '[') {
                        sb.insert(0, stack.pop()) //insert to the head of the string until meeting the opening bracket
                    }
                    val sub = sb.toString()  //substring to repeat
                    stack.pop() //pop the opening bracket

                    sb.clear() //reuse the sb for repeat count parsing
                    while (stack.isNotEmpty() && stack.peek().isDigit()) {
                        sb.insert(0, stack.pop())
                    }
                    val count = sb.toString().toInt()

                    repeat(count) { //repeat the substring to add back to the stack
                        sub.forEach { stack.push(it) }
                    }
                }
        }
        return stack.reversed().joinToString(separator = "")
    }
}