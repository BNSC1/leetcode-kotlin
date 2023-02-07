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
    fun oddEvenList(head: ListNode?): ListNode? {
        return head?.apply { //if head is not null
            var odd = head
            var even = head.next
            val firstOdd = head
            val firstEven = head.next

            while (even != null && even.next != null) {
                odd!!.next = odd.next.next //odd.next.next will be in an odd index, add to the odd group
                even!!.next = even.next.next //even.next.next will be in an even index, add to the even group
                odd = odd.next //move the odd pointer to the latest odd index
                even = even.next //move the even pointer to the latest even index
            }
            //end of the linked list
            odd!!.next = firstEven //link the end of the odd group to the even group
        }
    }
}