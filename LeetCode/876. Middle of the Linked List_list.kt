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
        val list = mutableListOf<ListNode>()
        var node = head //start with head node

        while (node != null) { //while the node is not null, add it to the list
            list.add(node!!)
            node = node.next //move the node to the next one
        }

        return list[list.size / 2] //return node with the index of half size of the list
    }
}
