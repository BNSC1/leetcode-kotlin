class Solution {
    fun maxArea(hs: IntArray): Int {
        var res = 0
        var l = 0
        var r = hs.size - 1 //two pointers

        while (l < r) { //close loop when left and right meets
            val area = (r - l) * Math.min(hs[l], hs[r]) //(r - l) is width, take the lesser of left or right as height
            res = Math.max(res, area) //take the area as result if it is greater than current one

            if (hs[l] < hs[r]) {
                l++ //shift left pointer to right by 1 if it is already pointing to shorter height
            }
            else {
                r--
                //shift right pointer to left by 1 if it is already pointing to shorter or equal height
                //does not matter which pointer you are shifting if they point to equal height
            }
        }

        return res
    }
}
