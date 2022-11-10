class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var s = 0
        var e = nums.size - 1

        while (s <= e) {
            val m: Int = (e + s) / 2
            if (nums[m] == target) return m

            if (nums[s] <= nums[m]) {
            /* if start value and mid value are within the same "ramp"
            * |      /
            * |     m
            * |    /
            * |   s
            * |  /
            * |         /
            * |        /
            * -------------*/
                if (target > nums[m] || target < nums[s]) s = m + 1
                /* when target is within the same ramp, or not within, make start pointer m + 1
                * |      T         |      /
                * |     m          |     m
                * |    /           |    /
                * |   s         or |   s
                * |  /             |  /
                * |         /      |        /
                * |        /       |       T
                * -----------      -----------*/
                else e = m - 1
                /* if target is between start and mid, make end pointer m - 1
                * |      /
                * |     m
                * |    T
                * |   s
                * |  /
                * |         /
                * |        /
                * -----------*/

            } else {
                /* if start value and mid value are not within the same "ramp", means mid value and end value are within the same one
                * |   /
                * |  /
                * |        /
                * |       e
                * |      /
                * |     m
                * |    /
                * -----------*/
                if (target < nums[m] || target > nums[e]) e = m - 1
                /* when target is within the same ramp, or not within, make end pointer m - 1
                * |   /         |   T
                * |  /          |  /
                * |        /    |        /
                * |       e  or |       e
                * |      /      |      /
                * |     m       |     m
                * |    T        |    /
                * -----------   -----------*/
                else s = m + 1
                /* if target is between mid and end, make start pointer m + 1
                * |   /
                * |  /
                * |        /
                * |       e
                * |      T
                * |     m
                * |    /
                * -----------*/
            }
        }
        return -1
    }
}
