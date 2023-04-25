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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val minHeap = PriorityQueue<ListNode>(compareBy { it.`val` })
        lists.forEach { node ->
            node?.let { minHeap.add(it) }
        }

        val dummy = ListNode(-1)
        var last = dummy
        while (minHeap.isNotEmpty()) {
            var cur = minHeap.poll()
            last.next = cur
            last = last.next
            cur.next?.let { minHeap.add(it) } //add next node of the current list, to compare with ones in other nodes
        }
        return dummy.next
    }
}