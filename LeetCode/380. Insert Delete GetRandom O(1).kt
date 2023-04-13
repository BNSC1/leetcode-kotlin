class RandomizedSet() {
    val map = HashMap<Int, Int>() //val: index
    val nums = mutableListOf<Int>()

    fun insert(`val`: Int) =
        (`val` !in map).also { notExist ->
            if (notExist) {
                addVal(`val`)
            }
        }

    fun remove(`val`: Int) =
        (`val` in map).also { exist ->
            if (exist) {
                removeVal(`val`)
            }
        }

    fun getRandom() = nums.random()

    private fun addVal(`val`: Int) {
        nums.add(`val`)
        map[`val`] = nums.lastIndex
    }

    private fun removeVal(`val`: Int) {
        val targetIdx = map[`val`]!!
        val lastVal = nums.last()
        nums[targetIdx] = lastVal
        nums.removeAt(nums.lastIndex)
        map[lastVal] = targetIdx
        map.remove(`val`)
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */