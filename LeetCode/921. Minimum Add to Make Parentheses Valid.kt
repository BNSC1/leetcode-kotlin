class Solution {
    fun minAddToMakeValid(s: String): Int {
        var lefts = LinkedList<Int>()
        var rights = LinkedList<Int>()

        s.forEachIndexed { i, it ->
            if (it == '(') {
                lefts.push(i)
            } else {
                rights.push(i)
                if (lefts.isNotEmpty() && lefts.peek() < i) {
                    rights.poll()
                    lefts.poll()
                }
            }
        }

        return lefts.size + rights.size
    }
}