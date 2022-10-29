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
    fun isPalindrome(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while(fast != null && fast.next != null) { //slow/fast pointers to find the middle of the linked list
            slow = slow!!.next // slow pointer moves by 1
            fast = fast.next.next // fast pointer moves by 2
        }

        var prev: ListNode? = null
        while(slow != null) {
            val tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp //revert links of the 2nd-half of the list
        }

        var left = head //from start to middle
        var right = prev //from end to middle
        while (right != null) {
            if (left!!.`val` != right.`val`) { //return false if not palindrome
                return false
            }
            left = left.next //move right
            right = right.next //move left
        }
        return true //if palindrome, return true
    }
}
