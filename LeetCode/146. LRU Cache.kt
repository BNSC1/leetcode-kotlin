class LRUCache(val cap: Int) {
    val map = hashMapOf<Int, Node>() //hash map to store index of the node
    val head = Node(0, 0) //head node to link to the least recently used node
    val tail = Node(0, 0) //tail node to link to the most recently used/added node

    init { //init by linking head node and tail node
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        if (key in map) { //return the node value and readd it to the hash map, so we make it the most recently used one
            remove(map.getValue(key))
            add(map.getValue(key))
            return map.getValue(key).value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) { //if the key is in the hash map already, unlink it from the linked list first
            remove(map.getValue(key))
        }
        map[key] = Node(key, value) //add to the hash map
        add(map.getValue(key)) //and add it to the most recently used node.


        if (cap < map.size) { //if the map has reached the cap:
            val lru = head.next
            remove(lru!!) //unlink the least used node
            map.remove(lru.key) //and remove it from the hash map
        }
    }


    fun remove(node: Node) { //remove a node by
        val p = node.prev
        val n = node.next

        n!!.prev = p //linking its previous node with its next one
        p!!.next = n
    }

    fun add(node: Node) { //add a node by
        val p = tail.prev
        val n = tail

        n!!.prev = node //linking it to the previous of the tail node
        p!!.next = node //and the next of the most recently used node

        node.prev = p //then linking the new node to the next of the most recently used node
        node.next = n //and the previous of the tail node, becoming the new most recently used node
    }
}

class Node(val key: Int, val value: Int) {
    var prev: Node? = null
    var next: Node? = null
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
