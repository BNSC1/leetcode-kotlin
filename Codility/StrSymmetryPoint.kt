fun solution(S: String): Int {
    if (S.length%2!=0) {
        val mid: Int = S.length/2 // find mid index of the string.
        for (i in 0..mid) {
            if (S[i] != S[S.length - 1 - i]) return -1 // compare symmetry
        }
        return mid
    }
    return -1 //will never have a symmetry point if the length is even.
}

