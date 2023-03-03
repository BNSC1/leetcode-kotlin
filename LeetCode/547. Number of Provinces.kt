class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        var size = isConnected.size
        var res = 0
        val root = IntArray(size) { it } //init size of elements, with each element value to be their index

        fun unionFind(i: Int, j: Int) {
            var i = i
            var j = j
            while (root[i] != i) i = root[i] //find city v1's root
            while (root[j] != j) j = root[j] //find city v2's root
            if (root[i] != root[j]) root[j] = i //if city v2 hasn't formed a province (root is itself), assign v1 to be its root
        }

        for (i in 0 until size) {
            for (j in i + 1 until size) {
                if (isConnected[i][j] == 1) { //if i city and j city are a province
                    unionFind(i, j)
                }
            }
        }

        root.forEachIndexed { i, it ->
            if (it == i) { //if n cities have the same root, they only count as 1 province
                res++
            }
        }
        return res
    }
}