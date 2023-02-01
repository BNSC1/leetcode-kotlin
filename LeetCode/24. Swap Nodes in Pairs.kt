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
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0, head) //dummy node to keep track of the head node after swap
        var prev = dummy
        var current = head

        while (current != null && current.next != null) {
            val next2 = current.next.next
            val next = current.next //save next 2 pointers
            // prev->current->next->next2

            //swap their next
            next.next = current
            current.next = next2
            prev.next = next
            //          ---------
            //          ˇ       |
            // prev  current  next  next2
            //  |       |       ^     ^
            //  |       --------|------
            //  -----------------
            // result:
            // prev->next->current->next2

            // update pointers:
            // ____->____->prev->current
            prev = current
            current = next2
        }
        return dummy.next
    }
}
