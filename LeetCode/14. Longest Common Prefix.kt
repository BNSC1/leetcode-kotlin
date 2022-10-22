class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val res = StringBuilder()
        val first = strs[0]

        for (i in 0 until first.length) { // loop through each char of the first string
            strs.forEach { str -> // loop through each string
                // if going out of bounds of current string (happens when first string is longer than current string)
                // or when char differs between current string and first string
                // return the result
                if (i >= str.length || first[i] != str[i]) return res.toString()
            }
            // otherwise append current char to string builder
            res.append(first[i])
        }
        return res.toString()
    }
}
