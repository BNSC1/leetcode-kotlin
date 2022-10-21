class Solution {
    // you need to treat n as an unsigned value
    fun hammingWeight(num: Int) : Int {
        var res = 0
        var n = num

        while (n != 0) { //when n is exactly 0, it means there won't be any 1's
    		res += n and 1 //when the last bit of n is 1, add to result by 1
    		n = n ushr 1 //"ushr" to shift unsigned bits to right by 1
    	}
    	return res;
    } //SC: O(1), TC: O(1)
}
