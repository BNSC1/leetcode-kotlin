/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var s = 1
        var e = n

        while (s < e){
            val m = s+(e-s) / 2 //get the middle pointer between start and end
            if (isBadVersion(m)) { //if the middle pointer is bad already
                e = m //move the end pointer to the middle pointer
            } else {
                s = m+1 //else move the start pointer to the pointer after the middle one
            }
        }
        return s //return the start pointer when start and end meet each other
	}
}
