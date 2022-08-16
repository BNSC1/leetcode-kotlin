/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution { // HashSet
    fun hasCycle(head: ListNode?): Boolean {
        val hs = HashSet<ListNode>()
        var curr = head
        
        while (curr != null) {
            if (curr in hs) return true //return true if current node is in the hash set
            hs.add(curr) //add the node to the hash set
            curr = curr.next //switch current node to the next node
        }
        return false //return false if the node is null (not loop)
    }
}