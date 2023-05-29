class Solution {
    fun subdomainVisits(ds: Array<String>): List<String> {
        val map = HashMap<String, Int>().withDefault {0} //domain : count

        ds.forEach { str ->
            val cntDomain = str.split(' ')
            val cnt = cntDomain[0].toInt()
            val subs = cntDomain[1].split('.')
            var combine = ""
            for (i in subs.size - 1 downTo 0) {
                if (combine.isNotEmpty()) combine = "." + combine
                combine = subs[i] + combine
                map[combine] = map.getValue(combine) + cnt
            }
        }
        return map.entries.map {
            "${it.value} ${it.key}"
        }
    }
}