import java.util.*

fun solution(A: IntArray): Int {
    val map = HashMap<Int, Boolean>() //use hash map to check if the numbers have duplicate.
    val list = LinkedList<Int>() //use linked list to store the order of the numbers.

    for (i in A) {
        if (map.contains(i)) { // if the number has duplicate, make the boolean true in the hash map.
            map[i] = true
        } else { // if the number is new in the hash map, add the number to it, then add it to the linked list.
            map[i] = false
            list.add(i)
        }
    }
    while (list.isNotEmpty()) {
        val num = list.poll() //get and remove the first element from the linked list.
        if (!map.getValue(num)) { //if the number is unique, return it.
            return num
        }
    }
    return -1 //if the prior loop doesn't return, return -1.
}
