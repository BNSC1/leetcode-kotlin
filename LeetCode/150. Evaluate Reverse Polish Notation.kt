class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<String>() //for saving numbers to process

        tokens.forEach {
            when (it) {
                op.PLUS.s -> { //pop the 2 most recent numbers to add them, then add the result back to the stack
                    stack.add((stack.pop().toInt() + stack.pop().toInt()).toString())
                }
                op.MINUS.s -> { //pop the 2 most recent numbers
                    val subtract = stack.pop().toInt() //assign the most recent number for subtraction
                    val minuend = stack.pop().toInt() //assign the 2nd most recent number to be minuend
                    stack.add((minuend - subtract).toString()) //subtract them, then add the result back to the stack
                }
                op.MULTI.s -> { //pop the 2 most recent numbers then multiply them
                    stack.add((stack.pop().toInt() * stack.pop().toInt()).toString()) //multiply them, then add the result back to the stack
                }
                op.DIVIDE.s -> { //pop the 2 most recent numbers
                    val divisor = stack.pop().toInt() //assign the most recent number to be divisor
                    val dividend = stack.pop().toInt() //assign the 2nd most recent number to be dividend
                    stack.add((dividend / divisor).toString()) //divide them, then add the result back to the stack
                }
                else -> { //add to the stack if it is not an operator but a number
                    stack.add(it)
                }
            }
        }
        return stack.pop().toInt() //the last element in the stack should be the result
    }

    enum class op(val s: String) { //enum for operators
        PLUS("+"),
        MINUS("-"),
        MULTI("*"),
        DIVIDE("/");
    }
}
