class Solution {
    fun trap(h: IntArray): Int {
        if (h.isEmpty()) return 0
        var res = 0
        var l = 0
        var r = h.size - 1
        var maxL = h[l]
        var maxR = h[r]

        while(l < r) { //make sure the opposite side has enough height to trap water
            if (maxL < maxR) {
                l++
                maxL = Math.max(maxL, h[l])
                res += maxL - h[l]
            } else {
                r--
                maxR = Math.max(maxR, h[r])
                res += maxR - h[r]
            }
        }
        return res
    }
}