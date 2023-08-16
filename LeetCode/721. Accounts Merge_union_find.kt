class Solution {
    fun accountsMerge(accs: List<List<String>>): List<List<String>> {
        val parents = HashMap<String, String>() //child email: parent email
        val owners = HashMap<String, String>() //email: owner
        val unions = HashMap<String, TreeSet<String>>().withDefault {TreeSet()} //parent email : child emails, TreeSet will sort children automatically
        val res = mutableListOf<List<String>>()

        fun findParent(email: String): String =
            if (parents[email] === email) email else findParent(parents[email]!!)

        accs.forEach { acc ->
            val owner = acc[0]
            for (i in 1 until acc.size) {
                val email = acc[i]
                parents[email] = email //set each email to be its own parent, including the parent itself
                owners[email] = owner //set owner of each email
            }
        }
        accs.forEach { acc ->
            val parent = findParent(acc[1])
            for (i in 2 until acc.size) {
                val email = acc[i]
                parents[findParent(email)] = parent
            } //set other emails in the account to have the first email in the account as parent email
        }
        accs.forEach { acc ->
            val parent = findParent(acc[1])
            for (i in 1 until acc.size) {
                unions[parent] = unions.getValue(parent).apply {add(acc[i])}
            } //assign emails with the same parent to 1 set
        }
        unions.keys.forEach { parent ->
            val emails = LinkedList(unions[parent]!!).apply {push(owners[parent])} //new a list with emails in it, then push the owner to start of it
            res.add(emails)
        }
        return res
    }
}

/*
1. The key task here is to connect those emails, and this is a perfect use case for union find.
2. to group these emails, each group need to have a representative, or parent.
3. At the beginning, set each email as its own representative.
4. Emails in each account naturally belong to a same group, and should be joined by assigning to the same parent (let's use the parent of first email in that list);
*/
