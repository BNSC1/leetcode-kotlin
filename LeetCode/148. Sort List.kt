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
    fun sortList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) { //edge case with 0 or 1 node
            return head
        }

        var left = head
        val mid = getMid(head)
        var right = mid.next
        //break down to 2 linked lists
        mid.next = null //with the end of the left list pointed to null

        left = sortList(left)
        right = sortList(right) //break the lists down further
        return merge(left, right)
    }

    fun getMid(head: ListNode): ListNode {
        var slow = head
        var fast = head?.next

        while (fast != null && fast.next != null) {
            slow = slow!!.next
            fast = fast.next.next
        }
        return slow!! //return slow as the mid pointer when fast is at bound (even num of nodes) or out of bound (odd num of nodes)
    }

    fun merge(l1: ListNode?, l2: ListNode?): ListNode {
        var list1 = l1
        var list2 = l2
        val dummy = ListNode() //dummy node to keep track of where the actual first node is
        var tail = dummy //tail node to track the end of the list

        while (list1 != null && list2 != null) {
            if (list1.`val` < list2.`val`) { //if the pointed node in list1 has smaller value than the one in list2
                tail.next = list1 //add the one in list1 to the end of the linked list
                list1 = list1.next //shift the pointer
            } else {
                tail.next = list2
                list2 = list2.next
            }
            tail = tail.next //shift the tail node
        }
            list1?.let { //if list2 node is null but list1 node is not, assign the list1 node to the end
                tail.next = it
            }
            list2?.let { //if list1 node is null but list2 node is not, assign the list2 node to the end
                tail.next = it
            }

        return dummy.next //return the first node
    }
}