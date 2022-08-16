/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution { // Floyd's Tortoise and Hare
    fun hasCycle(head: ListNode?): Boolean {
        var s = head //slow pointer
        var f = head //fast pointer
        
        while (f != null && f.next != null) {
            s = s!!.next //slow pointer moves by 1 node
            f = f!!.next!!.next //fast pointer moves by 2 nodes
            if (s == f) return true //return true if slow and fast pointer meet each other
            //if the linked list is a loop, then the fast pointer will eventually meet the slow pointer
        }
        return false //return false if the fast pointer and the next pointer of the fast one is null (not loop)
    }
}