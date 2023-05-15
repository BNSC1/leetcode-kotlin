class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        return derived.reduce { res, i ->
            res xor i
        } == 0 //the condition for a vaild original array is to have xor 0 over elements
    }
}