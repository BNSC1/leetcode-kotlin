class Solution {
    fun addBinary(a: String, b: String): String {
        var carry = 0
        var posA = a.length-1
        var posB = b.length-1 //position will start from right of the strings
        val res = StringBuilder()

        while (posA >= 0 || posB >= 0) {
            var sum = carry //set sum as carry first

            if (posA >= 0) sum += a[posA--] - '0' //if posA isn't below 0, add digit of the position to sum, then posA - 1
            if (posB >= 0) sum += b[posB--] - '0' //if posB isn't below 0, add digit of the position to sum, then posB - 1
            res.append(sum % 2) //append residue of sum
            carry = sum / 2 //add to carry if sum is greater than 2
        }
        if (carry != 0) res.append(carry) //if there is leftover carry after the loop, append a new digit
        return res.reversed().toString() //reverse the string builder then output the string
    }
}
