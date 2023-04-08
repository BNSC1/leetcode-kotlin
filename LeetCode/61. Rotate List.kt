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
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        head?.let {
            var length = 1
            var oldTail = head
            while (oldTail?.next != null) {
                oldTail = oldTail.next
                length++
            }

            var k = k % length
            if (k == 0) return head //if it's moddable by length, meaning it does not do a rotation

            var newTail = head
            repeat(length - k - 1) {
                newTail = newTail!!.next
            }

            val newHead = newTail!!.next
            newTail!!.next = null
            oldTail!!.next = head
            return newHead

        } ?: return head
    }
}