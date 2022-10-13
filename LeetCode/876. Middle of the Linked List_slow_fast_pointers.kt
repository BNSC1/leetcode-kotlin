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
    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        while (fast != null && fast!!.next != null) { //when the fast pointer reached the end of the linked list
            slow = slow!!.next //slow pointer moves by 1 step
            fast = fast!!.next!!.next //fast pointer moves by 2 steps
        }

        return slow //we return the slow pointer
    }
}
