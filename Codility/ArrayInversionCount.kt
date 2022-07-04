import java.util.*

val max = 1000000000
fun mergeSort(A: IntArray, s: Int, e: Int): Int {
    var cnt = 0

    if (s < e) { //as long as start index is before end index.
        val m: Int = (s+e)/2

        cnt += mergeSort(A, s, m) //split current array by half, take the left subarray.
        cnt += mergeSort(A, m+1, e) //split current array by half, take the right subarray.
        cnt += merge(A, s, m+1, e)

    }
    return if (cnt <= max) cnt else -1
}

fun merge(A: IntArray, s: Int, m: Int, e: Int): Int {
    var i = s //pointer for left array.
    var j = m //pointer for right array.
    var k = 0 //pointer for temp array.
    var swaps = 0
    val tmp = IntArray(e-s+1)

    while (i < m && j <= e) { //while pointers haven't reached bound.
        if (A[i] <= A[j]) {
            tmp[k++] = A[i++] //add the left array number to array if it is smaller than the right one.
        } else {
            tmp[k++] = A[j++] //add the right array number.
            swaps += m - i //calculate and add how far this number is swapped.
        }
    }
    while (i < m) { //not paired left array numbers
        tmp[k++] = A[i++] //add to array
    }
    while (j <= e) { //not paired right array numbers
        tmp[k++] = A[j++] //add to array
    }

    i = s
    k = 0
    while (i <= e) { //write tmp array to main array
        A[i++] = tmp[k++]
    }
    return swaps
}

fun solution(A: IntArray): Int {
    return mergeSort(A, 0, A.size-1)
}
