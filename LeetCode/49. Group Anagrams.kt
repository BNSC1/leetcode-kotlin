class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val res = HashMap<String, MutableList<String>>() //sorted string: strings from str

        strs.forEach {
            val key = it.asSequence().sorted().joinToString() //sort the key char in alphabetical order
            res[key] = res.getOrDefault(key, mutableListOf())
                          .apply { add(it) } //assign the list back to the key with the string added, or when the key does not have a list assigned, create a new one then add the string
        }
        return res.values.toList() //return the map value as list
    }
}
