class Solution {
    val parents = HashMap<String, String>() //child email: parent email

    fun accountsMerge(accs: List<List<String>>): List<List<String>> {
        val owner = HashMap<String, String>() //email: owner
        val unions = HashMap<String, TreeSet<String>>() //parent email: set of children email, TreeSet will sort elements automatically
        val res = mutableListOf<List<String>>()

        accs.forEach { a ->
            for (i in 1 until a.size) {
                parents[a[i]] = a[i] //set each email to be its own parent, including the parent itself
                owner[a[i]] = a[0] //set owner of each email
            }
        }
        accs.forEach { a ->
            val p = find(a[1])
            for (i in 2 until a.size) parents[find(a[i])] = p //set other emails in the account to have the first email in the account as parent email
        }
        accs.forEach { a ->
            val p = find(a[1])
            if (p !in unions) unions[p] = TreeSet() //new a set if the parent does not exist in the map
            for (i in 1 until a.size) unions[p]!!.add(a[i]) //assign emails with the same parent to 1 set
        }
        for (p in unions.keys) {
            val emails = LinkedList(unions[p]!!).apply { push(owner[p]) } //new a list with emails in it, then push the owner to start of it
            res.add(emails) //add to result
        }
        return res
    }

    fun find(email: String): String = // find parent email of this email
        if (parents[email] === email) email else find(parents[email]!!)
}

/*
1. The key task here is to connect those emails, and this is a perfect use case for union find.
2. to group these emails, each group need to have a representative, or parent.
3. At the beginning, set each email as its own representative.
4. Emails in each account naturally belong to a same group, and should be joined by assigning to the same parent (let's use the parent of first email in that list);
*/
