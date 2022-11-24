class Solution {
    fun sortColors(nums: IntArray) {
        var red = 0
        var white = 0
        var blue = nums.size - 1

        while(white <= blue) {
            if (nums[white] == 0) { //when white pointer is pointing to red element
                val tmp = nums[red]
                nums[red] = nums[white]
                nums[white] = tmp //swap red pointer element with white pointer element

                white++
                red++ //the pointed element is in correct position, increment both what they are pointing to by 1
            } else if (nums[white] == 1) { //if white pointer is pointing to white element
                white++  //increment white pointer by 1
            } else { //when white pointer is pointing to blue element
                val tmp = nums[white]
                nums[white] = nums[blue]
                nums[blue] = tmp //swap white pointer element with blue pointer element
                blue-- //subtract by 1 as the previous element does not need moving anymore
            }
        }
    }
}
