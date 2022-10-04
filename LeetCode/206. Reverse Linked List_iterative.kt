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
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null //the prev node will start as null
        var next = head //the next node will start as head node

        while (next != null) { //when the next node is not null
            val tmp = next.next //save the original next node to tmp
            next.next = prev //assign the original previous node to be the next node
            prev = next //assign the prev node forward
            next = tmp //assign the next node forward
        }

        return prev
    }
}
// prev->next
// prev->next->tmp
// prev<-next  tmp
// ____<-prev  next
