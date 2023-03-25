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
    fun reorderList(head: ListNode?): Unit {
        var slow = head
        var fast = head?.next

        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next.next
        } //locate the mid node

        var second = slow!!.next //second part of the list
        var prev: ListNode? = null 
        slow!!.next = null //unlink the end of the first list
        while (second != null) {
            val oldNext = second.next
            second.next = prev
            prev = second
            second = oldNext
        } //swap the second part

        var first = head
        second = prev
        while (second != null) {
            val old1stNext = first!!.next
            val old2ndNext = second.next
            first!!.next = second
            second.next = old1stNext
            first = old1stNext
            second = old2ndNext
        } //cross swap both parts
    }
    }