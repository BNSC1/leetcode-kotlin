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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val head = ListNode(-1) //head dummy node to avoid edge cases
        var tail = head //initialize by having head as tail

        var l1 = list1
        var l2 = list2 //parameters are immutable in Kotlin

        while (l1 != null && l2 != null) {
            if (l1.`val` > l2.`val`) {
                tail.next = l2
                l2 = l2.next
            } else {
                tail.next = l1
                l1 = l1.next
            } //link the tail to node with greater val, then switch to the next node of that node list
            tail = tail.next //switch the tail node to the newly linked node
        }

        l1?.let {
            tail.next = it
        }
        l2?.let {
            tail.next = it
        } //link leftover nodes to the tail
        return head.next
    }
}
