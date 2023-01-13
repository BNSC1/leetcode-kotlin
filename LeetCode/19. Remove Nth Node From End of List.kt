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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(-1).apply {
            next = head
        } //dummy head node with actual head node as its next node
        var n = n
        var l = dummy
        var r = head
        // D->1->2->3->4->5
        // l  r

        while (n > 0 && r != null) {
            r = r.next
            n--
        } //shift the right pointer by n nodes
        // D->1->2->3->4->5
        // l     r

        while (r != null) {
            l = l.next
            r = r.next
        } //then shift both pointers until the right pointer is at the end of the linked list
        // D->1->2->3->4->5
        //          l     r

        l.next = l.next.next //reassign the next node of the left pointer to be the next next node
        // D->1->2->3---->5
        //          l
        // right pointer does not matter anymore
        return dummy.next //return the shifted head node instead of the initial head node for case where the only node in the list is removed
    }
}
