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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0 //carries to the next number, or next next if it has 2 digits
        var m1 = l1
        var m2 = l2 //arguments are immutable in kotlin

        val dummy = ListNode(-1)
        var curr = dummy //init a dummy node to have access over the first node

        while (m1 != null || m2 != null || carry > 0) {
            m1?.let {
                carry += it.`val`
                m1 = it.next
            }
            m2?.let {
                carry += it.`val`
                m2 = it.next
            } //add their val to carry and move to their next node respectively
            curr.next = ListNode(carry % 10) //remainder is the number for current node
            carry = carry / 10 //move the carry down by 1 digit, if it is still greater than 0, will be sum to the next number
            curr = curr.next //move to the next node
        }
        return dummy.next //return the first actual number node when both lists reach the end and has no more number to carry
    }
}