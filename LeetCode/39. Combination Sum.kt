class Solution {
    fun combinationSum(cs: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        fun backtrack(remain: Int,
                      i: Int = 0,
                      tmp: MutableList<Int> = mutableListOf()) {
            if (remain < 0 || i >= cs.size) return //sum is over target value or iterate is going over candidates
            if (remain == 0) res.add(tmp.toList()) //combination reaches target value, add it to result, toList() to make a copy of current temp list
            else {
                tmp.add(cs[i]) //add current current iterate of candidates to temp list
                backtrack(remain - cs[i], i, tmp) //backtrack with remaining number, with current iterate because we can reuse the same number, going deeper in a decision tree with this method
                tmp.removeAt(tmp.size - 1) //restore to previous state for another decision after backtracking, as in java, list is passed by reference
                backtrack(remain, i+1, tmp) //use the next candidate for backtrack, going broader in a decision tree with this method
            }
        }

        backtrack(target) //initial target value
        return res
    }
}
