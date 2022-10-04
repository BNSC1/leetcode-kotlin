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
        return reverse(null, head) //the prev node will start as null, the next node will start as head node
    }

    fun reverse(prev: ListNode?, next: ListNode?): ListNode? {
        next?.let { //when the next node is not null
            val tmp = it.next //save the original next node to tmp
            it.next = prev //assign the original previous node to be the next node
            return reverse(it, tmp) //prev node and next node forward
        }
        return prev
    }
}
// prev->next
// prev->next->tmp
// prev<-next  tmp
// ____<-prev  next
