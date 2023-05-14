/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(-1).apply {next = head}
        var prevGroup = dummy

        fun getKth(): ListNode? {
            var k = k
            var curr: ListNode? = prevGroup
            while (curr != null && k > 0) {
                curr = curr!!.next
                k--
            }
            return curr
        }

        var currGroupEnd = getKth()
        while (currGroupEnd != null) {
            val nextGroup = currGroupEnd.next

            var prev = nextGroup
            var curr = prevGroup.next
            while (curr != nextGroup) { //while current node is still within the group
                val tmp = curr.next //reverse group elements
                curr.next = prev
                prev = curr
                curr = tmp
            }
            //update group
            val tmpGroup = prevGroup.next
            prevGroup.next = currGroupEnd
            prevGroup = tmpGroup
            currGroupEnd = getKth()
        }
        return dummy.next
    }
}