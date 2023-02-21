class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var l = 0
        var offset = arr.size - k //an offset to the window tail

        while (l < offset) {
            val m = (l + offset) / 2
            //determine if m should be the new l or offset
            if (x - arr[m] > arr[m + k] - x) { 
                l = m + 1 //if the window head is further to the x than the window tail, move the window forward, with window head at m + 1
            } else {
                offset = m //if the window tail is further to the x than the window head, or is equal, make m the new tail offset
            }
        }
        return arr.copyOfRange(l, l + k).toList()
    }
}